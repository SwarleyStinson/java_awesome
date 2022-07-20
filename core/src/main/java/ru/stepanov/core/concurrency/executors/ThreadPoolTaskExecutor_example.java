package ru.stepanov.core.concurrency.executors;

import lombok.SneakyThrows;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Random;

public class ThreadPoolTaskExecutor_example {

    @SneakyThrows
    public static void main(String[] args) {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(1);
        pool.setMaxPoolSize(5);
        pool.setQueueCapacity(20);
        pool.setKeepAliveSeconds(3);
        pool.initialize();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            pool.submit(() -> {
                try {
                    Thread.sleep(random.nextInt(10) * 1_000 + 1_000);
                } catch (InterruptedException e) {
                }
            });
        }

        System.out.println(
                "\ncore_pool_size=" + pool.getCorePoolSize()
                        + "\npool_size=" + pool.getPoolSize()
                        + "\nactive=" + pool.getActiveCount()
        );
        pool.shutdown();
    }
}
