package java_awesome;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.JdkSslContext;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;
import spring.model.BookReq;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SimpleTest {
    static SSLContext sslContext;
    static TcpClient tcpClient;
    static WebClient client;

    @SneakyThrows
    static X509TrustManager trustManagerForCertificates() {
        X509TrustManager x509Tm = null;
        val tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

        for (TrustManager tm : tmf.getTrustManagers()) {
            if (tm instanceof X509TrustManager) {
                x509Tm = (X509TrustManager) tm;
                break;
            }
        }

        val finalX509Tm = x509Tm;
        return new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return finalX509Tm.getAcceptedIssuers();
            }

            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
            }
        };
    }

    static {
        try {
            sslContext = SSLContext.getInstance("TLSv1.2");
            val kmf = KeyManagerFactory.getInstance("SunX509");
            val keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new ClassPathResource("cert/client.pfx").getInputStream(), "1234".toCharArray());

            kmf.init(keyStore, "1234".toCharArray());
            sslContext.init(kmf.getKeyManagers(), new TrustManager[]{trustManagerForCertificates()}, null);
        } catch (Exception e) {
        }
        tcpClient = TcpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 60_000)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(2_000, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(5_000, TimeUnit.MILLISECONDS));
                })
                .secure(spec -> spec.sslContext(new JdkSslContext(sslContext, true, ClientAuth.NONE)));


        client = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }

    //    @Ignore
    @SneakyThrows
    @Test
    public void test() {
        log.error("START reactive sending");

        val entity = client.post()
                .uri("http://localhost:8181/book")
                .body(BodyInserters.fromObject(new BookReq("Lord of the Rings", "Tolkin", "NO")))
                .exchange()
                .flatMap(response -> response.toEntity(BookReq.class))
                .block();

        val body = (BookReq) entity.getBody();

//        retreiveBook(new BookReq("Lord of the Rings", "Tolkin", "NO"))
//                .doOnError(error -> log.error("Error occured", error))
//                .doOnComplete(() -> log.info("Complete successfully"))
//                .subscribe(book -> log.warn("Received book: " + book.toString()));

//        retreiveBook(new BookReq("Book of the Jungle", "Kippling", "NO"))
//                .doOnError(error -> log.error("Error occured", error))
//                .doOnComplete(() -> log.info("Complete successfully"))
//                .subscribe(book -> log.warn("Received book: " + book.toString()));
//
//        retreiveBook(new BookReq("Eugeny Onegin", "Pushkin", "NO"))
//                .doOnError(error -> log.error("Error occured", error.getStackTrace()))
//                .doOnComplete(() -> log.info("Complete successfully"))
//                .subscribe(book -> log.warn("Received book: " + book.toString()));

        log.error("END reactive sending");

        while (true) {
            Thread.sleep(1_000);
            System.out.println(1);
        }
    }

    //todo WebClientResponseException

    static Flux<BookReq> retreiveBook(BookReq book) {
        return client.post()
                .uri("http://localhost:8181/book")
                .body(BodyInserters.fromObject(book))
                .retrieve()
                .bodyToFlux(BookReq.class);
    }
}
