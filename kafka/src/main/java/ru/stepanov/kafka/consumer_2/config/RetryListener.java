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

        return super.open(context, callback);
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        if (context.getRetryCount() == 1) {
            logger.error("Processing error. Start retry attempts", context.getLastThrowable());
        } else {
            logger.error("Retry attempt " + (context.getRetryCount() - 1) + " failed. ", context.getLastThrowable());
        }
        super.onError(context, callback, throwable);
    }
}
