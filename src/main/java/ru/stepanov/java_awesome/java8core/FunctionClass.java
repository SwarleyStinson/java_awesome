package ru.stepanov.java_awesome.java8core;

import com.google.common.base.Function;

public class FunctionClass {
    public static void main(String[] args) {
        Function<Integer, String> m1 = FunctionClass::staticMethod;

        System.out.println(m1.apply(1));
    }

    public static String staticMethod(int i) {
        return i == 0
                ? "12345"
                : "54321";
    }
}
