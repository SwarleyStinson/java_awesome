package ru.stepanov.kafka.producer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ConfigProducer {

    private final Properties properties;

    @Bean
    public DefaultKafkaProducerFactoryCustomizer customizeJsonSerializer(ObjectMapper objectMapper) {
        return consumerFactory -> consumerFactory.setValueSerializer(new JsonSerializer<>(objectMapper));
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.bootstrapServers);

        configProps.put(ProducerConfig.ACKS_CONFIG, properties.acks);

        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


        configProps.put("metadata.max.age.ms", 10000);
        configProps.put("metadata.max.idle.ms", 10000);
        configProps.put("retry.backoff.ms", 1000);
        configProps.put("linger.ms", 100);
        configProps.put("request.timeout.ms", 60000);
        configProps.put("enable.idempotence", true);
        configProps.put("delivery.timeout.ms", 180300);
        configProps.put("max.block.ms", 180000);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
