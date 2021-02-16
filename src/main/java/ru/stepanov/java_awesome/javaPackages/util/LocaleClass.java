package ru.stepanov.java_awesome.javaPackages.util;

import lombok.val;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class LocaleClass {

    public static void main(String[] args) {
        String code = "UK";

        val locale = new java.util.Locale("", code);

        System.out.println(locale.getDisplayCountry(java.util.Locale.ENGLISH));
        System.out.println(locale.getCountry());
        System.out.println(locale.getISO3Country());

        String[] isoCountries = Locale.getISOCountries();

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < isoCountries.length; i++) {
            map.put((new Locale("", isoCountries[i])).getISO3Country(), isoCountries[i]);
        }

        Map<String, String> collect = Arrays.stream(isoCountries)
                .collect(Collectors.toMap(
                        x -> (new Locale("", x)).getISO3Country(),
                        x -> x)
                );

        System.out.println(2);
    }
}
