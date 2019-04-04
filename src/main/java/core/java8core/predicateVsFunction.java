package core.java8core;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class predicateVsFunction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        int i1 = sumAll(numbers, n -> true);
        int i2 = sumAll(numbers, n -> n % 2 == 0);
        int i3 = sumAll(numbers, n -> n > 3);
    }


    public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }
}
