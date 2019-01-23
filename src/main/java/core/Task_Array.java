package core;


import java.util.Arrays;
import java.util.List;

public class Task_Array {
    /** DECLARATION */
    int[] array;  // предпочтительный способ
    int array2[]; // тоже правильный, но не предпочтительный.

    /** INITIALIZATION */
    static int[] array1 = new int[100];
    static int[] array3 = {1, 3, 2, 5};

    public static void main(String[] args) {
        /** STATIC METHODS */
        List<Integer> list = Arrays.asList(1, 2, 3); // преобразует аргументы в List<T>

        System.out.println(Arrays.equals(array3, new int[10])); // сравнение двух массивов
        System.out.println(Arrays.binarySearch(array3, 3));
        System.out.println(array3);
        Arrays.sort(array3);  //  сортирует массив
        
        System.out.println(array3);
        System.out.println(array1.length);
    }
}
