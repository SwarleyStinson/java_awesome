package ru.stepanov.core.core.data_structure;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SyncroniousQueue_my {
    @SneakyThrows
    public static void main(String[] args) {
        BlockingQueue<Boolean> buffer = new ArrayBlockingQueue<>(1);
        new Thread(
                new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        Thread.sleep(2_000);
                        System.out.println("1 - вставляю true");
                        buffer.put(true);
                        System.out.println("1 -  вставил true");
                        System.out.println("1 - вставляю false");
                        buffer.put(false);
                        System.out.println("1 -  вставил false");
                    }
                }
        ).start();
        new Thread(
                new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        System.out.println("2 - беру в первый раз");
                        System.out.println("2 - " + buffer.take());
                        System.out.println("2 - беру во второй раз");
                        System.out.println("2 - " + buffer.take());
                    }
                }
        ).start();

        Thread.sleep(3_000);
    }
}
