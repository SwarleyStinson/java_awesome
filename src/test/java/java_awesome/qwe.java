package java_awesome;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.util.Base64;

public class qwe {

    @Test
    @SneakyThrows
    public void set() {
        val path = "img/barcode.png";

        val in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        val bytes = IOUtils.toByteArray(in);
        val encodedString = Base64.getEncoder().encodeToString(bytes);
    }
}
