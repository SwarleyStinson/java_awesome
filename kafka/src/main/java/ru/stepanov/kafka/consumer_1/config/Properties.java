package ru.stepanov.kafka.consumer_1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
    @Value("${spp.kafka.topic}")
    public String topic;

    @Value("${spp.kafka.group}")
    String group;

    @Value("${spp.kafka.bootstrapServer}")
    String bootstrapServers;

    @Value("${spp.kafka.sessionTimeoutMillis}")
    String sessionTimeoutMillis;

    @Value("${spp.kafka.rebalanceTimeoutMillis}")
    String rebalanceTimeoutMillis;
}
