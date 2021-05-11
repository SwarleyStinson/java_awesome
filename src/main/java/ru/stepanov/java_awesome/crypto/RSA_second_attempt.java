package ru.stepanov.java_awesome.crypto;

import kotlin.text.Charsets;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import wiremock.org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSA_second_attempt {
    private static final int KEY_LENGTH = 2048;
    private static final String ALGORITHM = "RSA";
    private static final String METHOD = "RSA/ECB/PKCS1Padding";

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        val originalFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("cert/exampleEncrypted.txt");
        val originalString = IOUtils.toString(originalFile, Charsets.UTF_8);
        byte[] originalBytes = Hex.decodeHex(originalString.toCharArray());

        val publicKey = getPemPublicKey("cert/public.pem");
        val privateKey = getPrivateKey("cert/private.pem");

        System.out.println("Original String: " + originalString);
        System.out.println("Original String len = " + originalBytes.length + " byte");

        //encrypt
//        byte[] resE = encrypt(publicKey, originalBytes);
//        System.out.println("Encrypted String len = " + resE.length);
//        System.out.println(HexCoding.encodeHexString(resE));

        //decrypt
        byte[] resD = decrypt(privateKey, originalBytes);
        System.out.println("Decrypted String len = " + resD.length);
        System.out.println("Decrypted String: " + Hex.encodeHexString(resD).toUpperCase());
    }

    static public byte[] encrypt(PublicKey publicKey, byte[] message) throws Exception {
        Cipher cipher = Cipher.getInstance(METHOD);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return doMagic(cipher, KEY_LENGTH / 8 - 11, message);
    }

    static public byte[] decrypt(PrivateKey privateKey, byte[] encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance(METHOD);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        System.out.println("encryptedMessage.length " + encryptedMessage.length);
        return doMagic(cipher, KEY_LENGTH / 8, encryptedMessage);
    }

    @SneakyThrows
    private static byte[] doMagic(Cipher cipher, int limit, byte[] message) {
        int position = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (position < message.length) {
            if (message.length - position < limit)
                limit = message.length - position;
            byte[] data = cipher.doFinal(message, position, limit);
            byteArrayOutputStream.write(data);
            position += limit;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static PrivateKey getPrivateKey(String keyFile) throws Exception {
        KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
        val url = Thread.currentThread().getContextClassLoader().getResource(keyFile);
        try (FileReader keyReader = new FileReader(new File(url.toURI())); PemReader pemReader = new PemReader(keyReader)) {
            PemObject pemObject = pemReader.readPemObject();
            byte[] content = pemObject.getContent();
            PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(content);
            return (RSAPrivateKey) factory.generatePrivate(privKeySpec);
        }
    }

    static public PublicKey getPemPublicKey(String keyFile) throws Exception {
        KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
        val url = Thread.currentThread().getContextClassLoader().getResource(keyFile);
        try (FileReader keyReader = new FileReader(new File(url.toURI())); PemReader pemReader = new PemReader(keyReader)) {
            PemObject pemObject = pemReader.readPemObject();
            byte[] content = pemObject.getContent();
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(content);
            return (RSAPublicKey) factory.generatePublic(pubKeySpec);
        }
    }
}

