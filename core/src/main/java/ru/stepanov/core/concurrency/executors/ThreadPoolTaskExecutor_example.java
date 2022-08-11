package ru.stepanov.core.concurrency.executors;

import lombok.SneakyThrows;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public class ThreadPoolTaskExecutor_example {

    @SneakyThrows
    public static void main(String[] args) {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(1);
        pool.setMaxPoolSize(15);
        pool.setQueueCapacity(0);
        pool.setKeepAliveSeconds(3);

        /** если пул заполнен, работай в потоке вызова */
        pool.setRejectedExecutionHandler(new CallerRunsPolicy());

        pool.initialize();
        Random random = new Random();
        for (int i = 0; i < 90; i++) {
            System.out.print(i + ",");
            pool.submit(() -> {
                try {
                    Thread.sleep(random.nextInt(4) * 1_000 + 2_000);
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
