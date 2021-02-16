package ru.stepanov.java_awesome.excercises;

public class Excercise_4 {

    /**
     *
     * */

    public static void main(String[] args) {

        double[] array = {2.04, 5.45, 7.12,2.04, 5.45, 7.12,2.04, 5.45, 7.12, 10.1};

        System.out.println("abs = " + abs(array));
    }

    static double abs (double[] array){
        double sum = 0;

        for(double a: array){
            sum += a;
        }

        return sum/array.length;
    }
}
