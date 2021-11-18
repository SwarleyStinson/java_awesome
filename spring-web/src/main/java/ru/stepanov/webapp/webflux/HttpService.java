//package ru.stepanov.webapp.webflux;
//
//import io.netty.channel.ChannelOption;
//import io.netty.handler.timeout.ReadTimeoutHandler;
//import io.netty.handler.timeout.WriteTimeoutHandler;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ReactiveHttpOutputMessage;
//import org.springframework.http.client.reactive.ReactorClientHttpConnector;
//import org.springframework.web.reactive.function.BodyInserter;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.netty.http.client.HttpClient;
//import reactor.netty.tcp.TcpClient;
//import ru.stepanov.webapp.model.BookReq;
//
//import java.net.URI;
//import java.nio.charset.Charset;
//import java.util.Collections;
//import java.util.concurrent.TimeUnit;
//
//public class HttpService {
//    //todo CREATION
//    WebClient web3 = WebClient
//            .builder()
//            .baseUrl("http://localhost:8181")
//            .defaultCookie("cookieKey", "cookieValue")
//            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
//            .build();
//
//
//    //todo CONFIGURATION
//    TcpClient tcpClient = TcpClient
//            .create()
//            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
//            .doOnConnected(connection -> {
//                connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
//                connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
//                //todo т.е. могу добавить свой хендлер с логированием?
//            });
//
//    WebClient client = WebClient.builder()
//            .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
//            .build();
//
//
//    //todo PREPARE REQUEST
//    WebClient.UriSpec<WebClient.RequestBodySpec> request2 = client.post();
//
//    WebClient.RequestBodySpec uri = client
//            .post()
//            .uri(URI.create("/resource"));
//
//    WebClient.RequestHeadersSpec<?> requestSpec2 = WebClient
//            .create("http://localhost:8181")
//            .post()
//            .uri(URI.create("/book"))
//            .body(BodyInserters.fromObject("data"));
//
//    BookReq book = new BookReq("Two towers", "J.R.R.Tolkin", "NO");
//    BodyInserter<Object, ReactiveHttpOutputMessage> bodyInserter
//            = BodyInserters.fromObject(book);
//
//    WebClient.ResponseSpec response1 = uri
//            .body(bodyInserter)
//            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .accept(MediaType.APPLICATION_JSON)
//            .acceptCharset(Charset.forName("UTF-8"))
//            .retrieve();
//
//
//}
