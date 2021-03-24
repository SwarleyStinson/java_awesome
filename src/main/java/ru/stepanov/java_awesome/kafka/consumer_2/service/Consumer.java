package ru.stepanov.java_awesome.kafka.consumer_2.service;

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
        Thread.sleep(500);
        System.out.println("RECEIVED group_1 consumer_2 (partition-" + partition + "):   " + message);
    }

//    @SneakyThrows
//    @KafkaListener(topics = "${spp.kafka.topic}", groupId = "${spp.kafka.group}-2")
//    public void listenGroup_2(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        Thread.sleep(4_000);
//        System.err.println("RECEIVED Gr2 (partition-" + partition + "):   " + message);
//    }

}
