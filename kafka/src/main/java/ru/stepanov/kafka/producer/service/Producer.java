package ru.stepanov.kafka.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;
import ru.stepanov.kafka.producer.config.Properties;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class Producer {

    static long counter = 0;

    private final Properties props;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    @Scheduled(fixedDelay = 1_000)
//    public void scheduleSend() {
//        try {
//            sendMessage("heartbeat", "knock-knock " + ++counter);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//    }

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 5; i++) {
            try {
                sendMessage(
                        props.topic,
                        "Hello from " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME) + " (num " + i + ")"
                );
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }


    void sendMessage(String topic, String message) {
        val future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("SEND:'" + message + "', with offset:'" + result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("NO SEND=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
