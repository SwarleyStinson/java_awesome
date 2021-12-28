package ru.stepanov.kafka.consumer_1.service;

import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @SneakyThrows
    @KafkaListener(topics = "${spp.kafka.topic}", groupId = "${spp.kafka.group}")
    public void listenGroup_1(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.print("\nRECEIVED group_1 consumer_1 (partition-" + partition + "):   " + message);
        System.out.print("     PROCESSING");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
    }

}
