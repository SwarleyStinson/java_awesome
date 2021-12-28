package ru.stepanov.kafka.model//package ru.stepanov.core
//
//import org.springframework.http.ResponseEntity
//import org.springframework.web.reactive.function.BodyInserters
//import org.springframework.web.reactive.function.client.ClientResponse
//import reactor.core.publisher.Mono
//
//class Sender : SimpleTest() {
//
//    fun sendRequest(): Mono<ResponseEntity<BookReq>> {
//        return client.post()
//                .uri("http://localhost:8181/book")
//                .body(BodyInserters.fromObject(BookReq("Lord of the Rings", "Tolkin", "NO")))
//                .exchange()
//                .flatMap { response: ClientResponse -> response.toEntity(BookReq::class.java) }
//    }
//
//}