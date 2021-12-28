package ru.stepanov.kafka.consumer_2.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ISO_TIME;

@Service
@RequiredArgsConstructor
public class Consumer {

    private final KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

//    @Scheduled(fixedDelay = 5_000)
//    public void test() {
//        kafkaListenerEndpointRegistry.getListenerContainers()
//                .forEach(listener -> {
//                    System.err.println(listener.getListenerId() + " running status : " + listener.isRunning());
//                });
//    }

    private int attemptCount = 0;

    @SneakyThrows
    @KafkaListener(topics = "heartbeat", groupId = "consumer-2")
    public void listenGroup_1(@Payload String message) {
        System.out.println("                HEARTBEAT : " + message);
    }

    @SneakyThrows
    @KafkaListener(topics = "${spp.kafka.topic}", groupId = "consumer-2", containerFactory = "kafkaContainerFactory", id = "reattempt-listener")
    public void listenWithReAttempt(@Payload String message) {
        System.out.println(now().format(ISO_TIME) + " RECEIVED : " + message);

        if (message.contains("num 4") && ++attemptCount <= 2) {
            throw new RuntimeException("DB connect");
//            sleepConsumer(3_000);
//            listenWithReAttempt(message);
        } else if (message.contains("num 5")) {
            throw new RuntimeException("2345");
        } else {
            Thread.sleep(1_000);
        }

        System.out.println(now().format(ISO_TIME) + " PROCESSED : " + message);
    }
}
