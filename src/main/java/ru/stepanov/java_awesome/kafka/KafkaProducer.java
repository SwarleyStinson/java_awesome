package ru.stepanov.java_awesome.kafka;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String topic, String message) {
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


    @PostConstruct
    public void scheduleSend() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                sendMessage("testTopic", "Hello from " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
            }
        }, 5_000);
    }

}
