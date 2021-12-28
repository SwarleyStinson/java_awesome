package ru.stepanov.kafka.consumer_2.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

public class RetryListener extends RetryListenerSupport {
    private Logger logger = LoggerFactory.getLogger(RetryListener.class);

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
        logger.error("Processing error. Srt retry attempts", context.getLastThrowable());
        return super.open(context, callback);
    }

    @Override
    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        logger.error("Stop retry attempt.");
        super.close(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        logger.error("Retry attempt failed. ", context.getLastThrowable());
        super.onError(context, callback, throwable);
    }
}
