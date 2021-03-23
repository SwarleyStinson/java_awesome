package ru.stepanov.java_awesome.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "${spp.kafka.topic}", groupId = "${spp.kafka.group}")
    public void listenGroupFoo(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition
    ) {
        System.err.println("RECEIVED (partition-" + partition + "):   " + message);
    }

}
