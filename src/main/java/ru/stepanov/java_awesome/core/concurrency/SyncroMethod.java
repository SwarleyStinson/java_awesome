package ru.stepanov.java_awesome.core.concurrency;

import lombok.SneakyThrows;
import lombok.val;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

import static java.time.temporal.ChronoUnit.MILLIS;

public class SyncroMethod {
    ReentrantLock lock = new ReentrantLock();

    AtomicReference<LocalDateTime> resource = new AtomicReference<>();

    public static void main(String[] args) {
        SyncroMethod syncroMethod = new SyncroMethod();
        val pool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            pool.submit(() -> {
                test(syncroMethod);
            });
        }
    }

    @SneakyThrows
    private static void test(SyncroMethod lesson) {
        Thread.sleep(new Random().nextInt(1_000));
        val s = lesson.getResource();
        System.out.println(Thread.currentThread().getId() + " - " + s);
    }

    @SneakyThrows
    synchronized LocalDateTime getResource() {
        LocalDateTime res = resource.get();
        if (res == null || LocalDateTime.now().isAfter(res.plus(100, MILLIS))) {
            System.out.println(Thread.currentThread().getId());
//            sleep(1_000);
            setResource(LocalDateTime.now());
        }
        return resource.get();
    }

    void setResource(LocalDateTime s) {
        this.resource.set(s);
    }

}
