package ru.stepanov.core.core;

import javax.validation.constraints.NotNull;

public class f15_validation {

    public static void main(String[] args) {
        String h = null;
        method(h);
    }

    static void method(@NotNull String s){
        System.out.println(s);
    }

}
