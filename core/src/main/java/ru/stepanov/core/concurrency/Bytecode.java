package ru.stepanov.core.concurrency;

public class Bytecode {
    public static void main(String[] args) {
        long time = System.nanoTime();
        for (int i = 0; i < 100_000_000; i++) {
            method_lower();
        }
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        for (int i = 0; i < 100_000_000; i++) {
            method_faster();
        }
        System.out.println(System.nanoTime() - time);
    }


    static void method_lower() {
        int a = 2;
        int b = 1;
        a += 1;
        if (a < b) {
            System.out.println("-\n");
        }
    }

    static void method_faster() {
        int a = 2;
        a += 1;
        int b = 1;
        if (a < b) {
            System.out.println("-\n");
        }
    }
}
