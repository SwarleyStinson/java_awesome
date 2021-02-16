package ru.stepanov.java_awesome.core.control_structures;

public class Finally {
    public static void main(String[] args) {
        String s = getText();
        System.out.println(s);
    }

    static String getText() {
        try {
            return "Hello World!";
        } finally {
            System.out.println("Finally...");
        }
    }
}
