package ru.stepanov.java_awesome.core.control_structures;

public class f4_ifElseSwitch {
    public static void main(String[] args) {

        int i = 5;

        if (i==5){
            try {
                throw new RuntimeException("");
            } catch (Exception e){
                System.out.println("CATCH");
            }
        }

        System.out.println("AFTER");
    }
}
