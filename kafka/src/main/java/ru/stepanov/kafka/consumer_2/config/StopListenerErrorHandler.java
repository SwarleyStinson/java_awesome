package ru.stepanov.kafka.consumer_2.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ContainerStoppingErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;

import java.util.List;

public class StopListenerErrorHandler extends ContainerStoppingErrorHandler {

    private static Logger log = LoggerFactory.getLogger(StopListenerErrorHandler.class);

    @Override
    public void handle(Exception e, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer, MessageListenerContainer container) {
//        log.error("sheet happens : ", e);
        super.handle(e, records, consumer, container);
    }
}
