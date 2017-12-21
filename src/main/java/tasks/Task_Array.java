package tasks;


import java.util.Arrays;
import java.util.Random;

public class Task_Array {
    int[] array;  // предпочтительный способ
    int array2[]; // тоже правильный, но не предпочтительный.

    static int[] array1 = new int[100];
    static int[] array3 = {1, 2, 3, 5};

    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(array3, 3));
        System.out.println(Arrays.equals(array3, new int[10]));
        System.out.println(array1.length);
    }
}
