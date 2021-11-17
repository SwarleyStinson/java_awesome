package ru.stepanov.core.thirdParty.lombok;

import lombok.SneakyThrows;

/**
 * позволяет не добавлять try/catch для "опасных" методов
 * */
public class SneakyThrowsClass {
    public static void main(String[] args) {
        System.out.println(method());
    }

    @SneakyThrows(RuntimeException.class)
    public static String method() {
        dangerousMethod();
        return "2";
    }

    private static void dangerousMethod() throws RuntimeException {
        throw new RuntimeException();
    }
}
