package ru.stepanov.java_awesome.concurrency;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.text.MessageFormat.format;


public class HappensBefore {
    int a = 0, b = 0, c = 0;
    volatile int x = 0;

    void write() {
        a = 1;
        b = 1;
        c = 1;

        x = 1;
    }

    void read() {
        int xx = x;

        int da = a;
        int db = b;
        int dc = c;

        System.out.println(format("{0}{1}{2}{3}", xx, da, db, dc));
    }

    @SneakyThrows
    public static void main(String[] args) {
        HappensBefore object = new HappensBefore();

        ExecutorService pool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 1_0; i++) {
            pool.submit(() -> object.read());
            pool.submit(() -> object.write());
        }

        Thread.sleep(1_000);
    }
}
