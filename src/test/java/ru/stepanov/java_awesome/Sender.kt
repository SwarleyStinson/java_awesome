package ru.stepanov.java_awesome

import org.springframework.http.ResponseEntity
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.ClientResponse
import reactor.core.publisher.Mono
import ru.stepanov.java_awesome.spring.model.BookReq

class Sender : SimpleTest() {

    fun sendRequest(): Mono<ResponseEntity<BookReq>> {
        return client.post()
                .uri("http://localhost:8181/book")
                .body(BodyInserters.fromObject(BookReq("Lord of the Rings", "Tolkin", "NO")))
                .exchange()
                .flatMap { response: ClientResponse -> response.toEntity(BookReq::class.java) }
    }

}