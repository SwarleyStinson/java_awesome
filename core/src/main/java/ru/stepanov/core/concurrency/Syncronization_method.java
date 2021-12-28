package ru.stepanov.core.concurrency;

import lombok.SneakyThrows;
import lombok.val;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import static java.time.temporal.ChronoUnit.MILLIS;

public class Syncronization_method {
    AtomicReference<LocalDateTime> resource = new AtomicReference<>();

    public static void main(String[] args) {
        Syncronization_method syncroMethod = new Syncronization_method();
        val pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.submit(() -> {
                test(syncroMethod);
            });
        }
    }

    @SneakyThrows
    private static void test(Syncronization_method lesson) {
        Thread.sleep(new Random().nextInt(1_000));
        val s = lesson.getResource_sync();
        System.out.println(Thread.currentThread().getId() + " - " + s);
    }

    @SneakyThrows
    synchronized LocalDateTime getResource_sync() {
        LocalDateTime res = resource.get();
        if (res == null || LocalDateTime.now().isAfter(res.plus(500, MILLIS))) {
            System.out.println(Thread.currentThread().getId() + " - set new");
            setResource(LocalDateTime.now());
        }
        return resource.get();
    }

    void setResource(LocalDateTime s) {
        this.resource.set(s);
    }

}
