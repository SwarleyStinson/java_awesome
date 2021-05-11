package ru.stepanov.java_awesome.javaPackages.time;

import lombok.val;

import java.time.LocalDate;
import java.util.Calendar;

public class LocalDateTime {
    public static void main(String[] args) {
//        val date = LocalDate.parse("2020.08");
        val calendar = Calendar.getInstance();
        calendar.set(2020, 2, 1);
        calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(1);
    }
}
