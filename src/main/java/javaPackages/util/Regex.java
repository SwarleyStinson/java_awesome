package javaPackages.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        String s = "test@sdfsd.ru";
        String s1 = "test@sdfsd.rvsdvsdf";
        String s2 = "test@sd@fsd.f";

        System.out.println(validate(s));
        System.out.println(validate(s1));
        System.out.println(validate(s2));
    }


    private static boolean validate(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
