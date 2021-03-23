package ru.stepanov.java_awesome.kafka.service;

import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @SneakyThrows
    @KafkaListener(topics = "${spp.kafka.topic}", groupId = "${spp.kafka.group}-1")
    public void listenGroup_1(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.err.println("RECEIVED_1 (partition-" + partition + "):   " + message);
    }

    @KafkaListener(topics = "${spp.kafka.topic}", groupId = "${spp.kafka.group}-2")
    public void listenGroup_2(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.err.println("RECEIVED_2 (partition-" + partition + "):   " + message);
    }

}
