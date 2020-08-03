package core.data_structure;


import java.util.Arrays;
import java.util.List;

public class f3_Array {
    /**
     * DECLARATION
     */
    int[] array;  // предпочтительный способ
    int array2[]; // тоже правильный, но НЕ предпочтительный.

    /**
     * INITIALIZATION
     */
    static int[] array1 = new int[100];
    static int[] array3 = {1, 3, 2, 5};
    static int[] array4 = new int[]{1, 3, 9, 5};

    public static void main(String[] args) {
        /** STATIC METHODS */
        List<Integer> list = Arrays.asList(1, 2, 3); // преобразует аргументы в List<T>

        /** СРАВНЕНИЕ двух массивов */
        System.out.println(Arrays.equals(array3, new int[]{1, 3, 9, 5}));
        System.out.println(Arrays.equals(array3, new int[]{1, 2, 3, 0}));
        System.out.println(Arrays.equals(array3, new int[]{1, 2}));


        System.out.println(Arrays.binarySearch(array3, 3));
        System.out.println(Arrays.toString(array3));

        /** Сортировка массива */
        Arrays.sort(array3);

        System.out.println(Arrays.toString(array3));
        System.out.println(array3.length);

        /** Проверка массива на наличие конкретного значения*/
        System.out.println(Arrays.asList(array3).contains(1));
        
    }
}
