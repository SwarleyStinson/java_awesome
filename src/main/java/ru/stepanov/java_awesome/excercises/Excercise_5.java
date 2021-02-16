package ru.stepanov.java_awesome.excercises;

public class Excercise_5 {

    public static void main(String[] args) {

        String s = String.valueOf((int) ((char) -1));
        Integer i = (int) ((char) -1);

        System.out.println(s);
        System.out.println(i);

        System.out.println("******************");
        System.out.println(Character.MAX_CODE_POINT);
        System.out.println(Character.MAX_VALUE);
        System.out.println(Character.MAX_HIGH_SURROGATE);
        System.out.println(Character.MAX_LOW_SURROGATE);
        System.out.println(Character.MAX_RADIX);
        System.out.println(Character.MAX_SURROGATE);
    }
}
