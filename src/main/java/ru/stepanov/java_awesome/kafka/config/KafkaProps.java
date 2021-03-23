package ru.stepanov.java_awesome.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaProps {
    @Value("${spp.kafka.topic}")
    public String topic;

    @Value("${spp.kafka.group}")
    String group;

    @Value("${spp.kafka.bootstrapServers}")
    String bootstrapServers;
}
