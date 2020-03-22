package java8core;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class predicateVsFunction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Predicate<Integer> always = n -> true;
        Predicate<Integer> evenNumber = n -> n % 2 == 0;
        Predicate<Integer> threeAndMore = n -> n >= 3;

        printAll(numbers, always);
        printAll(numbers, evenNumber);
        printAll(numbers, threeAndMore);

        /**
         * Композитный предикат -
         *                        состоит из нескольких предикатов
         *                        &&  AND
         *                        ||  OR
         *                        !   NEGATE
         * */

        System.out.println("\n___________.AND() - должны выполниться оба условия");
        printAll(numbers, threeAndMore.and(evenNumber));
        printAll(numbers, always.and(evenNumber));

        System.out.println("\n___________.OR() - true хотя бы один предикат");
        printAll(numbers, evenNumber.or(threeAndMore));

        System.out.println("\n___________.NEGATE() - true, если предикат false. Инвертирует предикат");
        printAll(numbers, evenNumber.negate());
    }


    public static void printAll(List<Integer> numbers, Predicate<Integer> p) {
        for (int number : numbers) {
            if (p.test(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}
