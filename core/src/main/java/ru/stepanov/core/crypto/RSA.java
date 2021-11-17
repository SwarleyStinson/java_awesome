package ru.stepanov.core.crypto;

import kotlin.text.Charsets;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import sun.security.jca.Providers;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

public class RSA {
    @SneakyThrows
    public static void main(String[] args) {
        val exampleOrigin = "02007224068028C0820016553691376269030900000000000000200003231037370000042211007000010037353533363931333736323639303330394432323131323031313739383732313130303030303030303030313030303030343832343834353339424750202020202020202020202020064301309F260868911D0C5CF0A1769F2701409F10120110904003220000000000000006220000FF9F37040FBFFE579F360200C8950500000000009A032103239C01009F02060000000020009F03060000000000005F2A020643820219809F1A0206439F33030008C85F3401018407A00000000410109F0607A00000000410109F34031F0302333333333333";
        val exampleEncrypted = "918D128A51E77F436F3791F556D9E605DB78D27B7346728B7918F86794A74F96DB0EF48AC7DC55A8CBD96D54D638990CFBC133D4ACFFB7A7A27AA1F0978CC5A7E4FDD0BB5ACACE592B477DC19EC5F96450B84815989030A5B1116BD582FCD5C04DD759A970F2A5CF405B07852901993CF5B3F4C9B98C108B8E3655DE737D81B1D1D318F35AD34AFE4E89696607333939E3AAE6B6678FE208623244DB0F8DCE38A5A52CF00571605145F6430A4C6E0402634560C3C6152DA1E0F70D20DBB1140742E03A5EBDF7FDD10BA94109D6F6B3BDB22CB0F346795CB81C624348C9530F8FB713ED0289E9EBD21B40C2BB613ABFE4D20F8E9EC632DE13AB25DB42445D901169AC884CFA4ED4246894FC1C4C0BD65A7E7424454CC4021A2090C0E790A1A90C206BB6D29D532BAB51462590D1707D45A7CB2117E7D6D73F7AE9D0A95F3335654973CA855D0B269731535E11FEEEBF7922B8376F18A2D372B82C1E175E0F52202A5EDD891D59528AB45169553E563EA30A0DD0C515745B9A9A99FFEC64EE4FF9C81907BF0B7E0F91EF1453C5139CC4AB6B03882D33D3E9F419F448ACAB85167BCD4E97A9496C3B6D4069CB1E3F848BABCFCAAAC957145BBA4622B9EA4B338B7F7BF4429F08C2EE813EA27FF2FF2DD6244931BF7C54727D46195E7CD44C01B4782C67DC82378AE33E231CA708756FF39BE99753B2FCAD075648B0C6074AF4194B";

        val pub = Thread.currentThread().getContextClassLoader().getResourceAsStream("cert/public.pem");
        val priv = Thread.currentThread().getContextClassLoader().getResourceAsStream("cert/private.pem");
//        val pub = Thread.currentThread().getContextClassLoader().getResourceAsStream("cert/public4096.pem");
//        val priv = Thread.currentThread().getContextClassLoader().getResourceAsStream("cert/private4096.pem");
//        val pub = Thread.currentThread().getContextClassLoader().getResourceAsStream("cert/publicLocal.pem");
//        val priv = Thread.currentThread().getContextClassLoader().getResourceAsStream("cert/privateLocal.pem");

        val publicKeyPEM = IOUtils.toString(pub, Charsets.UTF_8)
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "");
        val privateKeyPEM = IOUtils.toString(priv, Charsets.UTF_8)
                .replace("\r", "")
                .replace("\n", "")
                .replace("-----BEGIN RSA PRIVATE KEY-----", "")
                .replace("-----END RSA PRIVATE KEY-----", "");

        Security.addProvider(new BouncyCastleProvider());
//        val cipher = "RSA/None/NoPadding";
        val cipher = "RSA/ECB/PKCS1Padding";

//        /** дешифруем пример от УМ */
        val res = rsaDecrypt(Hex.decode(exampleEncrypted), privateKeyPEM, 256);
        val decryptExample = Hex.toHexString(
                decryptData(Hex.decode(exampleEncrypted.substring(0, 512)), privateKeyPEM, cipher)
        );

        /** шифруем и дешифруем */
        val hwEncrypted = encryptData("02007224068028C08200".getBytes(), publicKeyPEM, cipher);
        val hwDecrypted = decryptData(hwEncrypted, privateKeyPEM, cipher);
        assert "small text".equals(new String(hwDecrypted));

        /** шифруем и дешифруем пример от УМ*/
        val encryptArray = encryptData(Hex.decode(exampleOrigin), publicKeyPEM, cipher);
        val hex = Hex.toHexString(encryptArray).toUpperCase();
        val decrypt = decryptData(encryptArray, privateKeyPEM, cipher);
        val hex2 = Hex.toHexString(decrypt);
        assert exampleOrigin.equals(hex2);

        System.out.println(1);
    }

    @SneakyThrows
    public static byte[] encryptData(byte[] data, String publicKeyBase64, String cipher) {
        val spec = new X509EncodedKeySpec(Base64.decode(publicKeyBase64));

        val publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);

        val rsa = Cipher.getInstance(cipher);
        rsa.init(Cipher.ENCRYPT_MODE, publicKey);
        return rsa.doFinal(data);
    }

    @SneakyThrows
    public static byte[] decryptData(byte[] data, String privateKeyBase64, String cipher) {
        val spec = new PKCS8EncodedKeySpec(Base64.decode(privateKeyBase64));

        val privateKey = KeyFactory.getInstance("RSA").generatePrivate(spec);

        val rsa = Cipher.getInstance(cipher);
        rsa.init(Cipher.DECRYPT_MODE, privateKey);
        return rsa.doFinal(data);
    }


    public static String rsaDecrypt(byte[] inputArray, String rsaPrivateKey, int MAX_ENCRYPT_BLOCK) {
        String result = "";
        try {
            // Convert the Base64 encoded private key to a PrivateKey object
            byte[] buffer = Base64.decode(rsaPrivateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            // encryption
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            int inputLength = inputArray.length;
            System.out.println("Encrypted Bytes:" + inputLength);
            // Maximum number of encrypted bytes, which exceeds the maximum number of bytes required for packet encryption
            // logo
            int offSet = 0;
            byte[] resultBytes = {};
            byte[] cache = {};
            while (inputLength - offSet > 0) {
                if (inputLength - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(inputArray, offSet, MAX_ENCRYPT_BLOCK);
                    offSet += MAX_ENCRYPT_BLOCK;
                } else {
                    cache = cipher.doFinal(inputArray, offSet, inputLength - offSet);
                    offSet = inputLength;
                }
                resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
                System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length, cache.length);
            }
            result = Hex.toHexString(resultBytes);
        } catch (Exception e) {
            System.out.println("rsaDecrypt error:" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Decrypted result: " + result);
        return result;
    }

}
