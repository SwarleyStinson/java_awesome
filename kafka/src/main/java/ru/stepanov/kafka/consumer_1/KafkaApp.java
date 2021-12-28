package ru.stepanov.kafka.consumer_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KafkaApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApp.class, args);
    }
}
