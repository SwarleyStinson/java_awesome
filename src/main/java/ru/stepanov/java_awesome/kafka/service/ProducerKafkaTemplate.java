package ru.stepanov.java_awesome.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;
import ru.stepanov.java_awesome.kafka.config.KafkaProps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ProducerKafkaTemplate {

    private final KafkaProps props;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Scheduled(fixedDelay = 5_000)
    public void scheduleSend() {
        sendMessage(props.topic, "Hello from " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
    }


    void sendMessage(String topic, String message) {
        val future = kafkaTemplate.send(topic, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("SEND:'" + message + "', with offset:'" + result.getRecordMetadata().offset() + "'");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("NO SEND=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
