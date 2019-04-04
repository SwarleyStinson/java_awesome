package core.java8core;

import java.util.Arrays;
import java.util.List;

public class lambda {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        numbers.forEach(value -> System.out.println(value));

        numbers.forEach(System.out::println);


    }
}
