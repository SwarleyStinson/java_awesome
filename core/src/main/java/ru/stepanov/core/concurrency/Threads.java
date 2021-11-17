package ru.stepanov.core.concurrency;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.sleep;

/**
 * 1) проверять не прервали ли меня
 * 2) use volatile boolean or AtomicBoolean , которую могут изменять другие потоки и проверять её
 * future.get(TIMEOUT)
 * *
 * NEW - has not yet started is in this state.
 * RUNNABLE - executing in the JVM is in this state.
 * BLOCKED - is blocked waiting for a monitor lock is in this state.
 * WAITING - is waiting indefinitely for another thread to perform a particular action is in this state.
 * TIMED_WAITING - is waiting for another thread to perform an action for up to a specified waiting time is in this state.
 * TERMINATED - has exited is in this state.
 */
public class Threads {
    public static void main(String[] args) {
        // no kill thread
//        lesson_justTryInterrupt();
//        lesson_ThreadPool_shutdownNow();
//        lesson_ThreadPool_callable_cancel();

        //
//        lesson_success_isInterrupted();
        lesson_success_Future_get_with_timeout();
    }

    @SneakyThrows
    static void lesson_justTryInterrupt() {
        Thread t1 = new Thread(() -> {
            while (true) {
                infinity_write("Hello World", false);
            }
        });
        t1.start();
        System.out.println("log this parallel");
        sleep(2_500);
        t1.interrupt(); // not kill the thread, need without 1) explicit interruption checking  or 2) sleep()
    }

    @SneakyThrows
    static void lesson_ThreadPool_shutdownNow() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(() -> {
            while (true) {
                infinity_write("hello", true);
            }
        });
        pool.shutdown();        //  1) no new task accepted    2) previously submitted task are executed
        pool.shutdownNow();     // 1) + 2) + 3) attempt to stop current

//        pool.submit(() -> infinity_write("after shutdown"));   // RejectedExecutionException
    }

    @SneakyThrows
    static void lesson_ThreadPool_callable_cancel() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Object> future = pool.submit(() -> {
            while (true) {
                infinity_write("hello", true);
            }
        });
        future.cancel(true); // no guarantee
    }


    @SneakyThrows
    static void lesson_success_isInterrupted() {
        Thread t1 = new Thread(() -> {
            // 1 - explicit check
            while (!Thread.currentThread().isInterrupted()) {
            }
            System.out.println("request to interruption...");

            // 2 - interrupt when thread in sleep()
        });
        t1.start();
        t1.interrupt();
    }

    @SneakyThrows
    static void lesson_success_Future_get_with_timeout() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Object> future = pool.submit(() -> {
            while (true) {
                infinity_write("hello", true);
            }
        });
        try {
            future.get(3, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
            pool.shutdownNow();           //  без этого не завершится main, поскольку есть живые, породенные main, потоки
        }
    }

    @SneakyThrows
    private static void infinity_write(String text, boolean sleep) {
        while (true) {
            System.out.println(text);
            if (sleep) {
                sleep(1_000);     // but without this, thread WILL NOT STOPPED
            }
        }
    }
}
