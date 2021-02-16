package ru.stepanov.java_awesome.excercises;

import java.util.Scanner;

public class Excercise_2 {

    /**
     *   Weight in the Moon
     * */

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("enter your weght->");
        String s = "";
        Integer weight = 0;

        s = keyboard.nextLine();

        try {
            weight = Integer.valueOf(s);
            System.out.println("weight in the Moon ->" + weight * 0.17);
        } catch (NumberFormatException e) {
            System.out.println("Неккоректное число!");
        }
    }
}
