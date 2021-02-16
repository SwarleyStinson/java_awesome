package ru.stepanov.java_awesome.core;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class f8_dateTime {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        LocalDateTime second = LocalDateTime.parse("1970-01-01T00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));


        long s1 = second.toEpochSecond(ZoneOffset.ofHours(3));
        long s2 = second.toInstant(ZoneOffset.UTC)
                .atZone(ZoneOffset.ofHours(3))
                .toEpochSecond();
        System.out.println(1);
    }
}
