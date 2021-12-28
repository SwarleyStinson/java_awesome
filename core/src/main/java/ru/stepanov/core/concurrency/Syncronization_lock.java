package ru.stepanov.core.concurrency;

import lombok.SneakyThrows;
import lombok.val;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.time.temporal.ChronoUnit.MILLIS;

public class Syncronization_lock {
    public static void main(String[] args) {
        val owner = new ResourceOwner();
        val threads = 100;
        val pool = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            int finalI = i;
            pool.submit(() -> {
                if (finalI % 2 == 0) {
                    test_1(owner);
                } else {
                    test_2(owner);
                }
            });
        }
    }

    @SneakyThrows
    private static void test_1(ResourceOwner owner) {
        Thread.sleep(new Random().nextInt(1_000));
        val s = owner.getResourceAndUpdate();
        System.out.println(Thread.currentThread().getId() + " - " + s);
    }

    @SneakyThrows
    private static void test_2(ResourceOwner owner) {
        Thread.sleep(new Random().nextInt(1_000));
        val s = owner.getResource();
        System.out.println(Thread.currentThread().getId() + " - " + s);
    }
}

class ResourceOwner {
    ReentrantReadWriteLock.ReadLock readLock;
    ReentrantReadWriteLock.WriteLock writeLock;

    ResourceOwner() {
        val lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    private LocalTime resource;

    @SneakyThrows
    LocalTime getResourceAndUpdate() {
        try {
            writeLock.lock();
            LocalTime res = resource;
            if (res == null || LocalTime.now().isAfter(res.plus(100, MILLIS))) {
                val time = LocalTime.now();
                System.out.println(Thread.currentThread().getId() + " - SET NEW - " + time);
                this.resource = time;
            }
            return resource;
        } finally {
            writeLock.unlock();
        }
    }

    LocalTime getResource() {
        try {
            readLock.lock();
            return this.resource;
        } finally {
            readLock.unlock();
        }
    }
}
