package ru.stepanov.java_awesome.javaPackages.text;

import java.text.DecimalFormat;

public class DecimalFormatLibrary {

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.println(
                decimalFormat.format(385.01)
        );
    }
}
