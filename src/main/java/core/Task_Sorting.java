package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Task_Sorting {

    public static void main (String[] args) throws Exception {

        System.out.println("Программа создана для тестирования методов сортировки." +
                "\n1) для создания массива из 10 000 элементов" +
                "\n2) для создания массива из 100 000 элементов" +
                "\n3) для создания массива из 1 000 000 элементов\n->");

        SortArrayList array = new SortArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.parseInt(reader.readLine());

        switch(answer) {
            case (1) : {
                array.create(10000);
                break;
            }
            case (2) : {
                array.create(100000);
                break;
            }
            case (3) :{
                array.create(1000000);
                break;
            }
        }

        System.out.println("Выберите тип сортировки:\n1) Bubble\n2) перемешиванием\n"
                +"3) Quick Sort\n4) Gnome Sort\n->");
        int secanswer = Integer.parseInt(reader.readLine());

        switch (secanswer) {
            case(1) : {
                BubblesSort(array);
                main(null);
            }
            case(2) : {
                CocktailSort(array);
                main(null);
            }
            case(3) : {
                QuickSort(array);
                main(null);
            }
            case(4) : {
                GnomeSort(array);
                main(null);
            }
        }
    }

    private static class SortArrayList {

        private static Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();

        long Counter = 0;

        void create(int size) {
            long TimeOfCreation = System.currentTimeMillis();
            list.clear();
            for (int i = 0; i < size; i++) {
                list.add(rnd.nextInt());
            }
            TimeOfCreation = System.currentTimeMillis() - TimeOfCreation;
            System.out.println("Время создания коллекции - " + TimeOfCreation + "ms.");
        }
    }

    static void BubblesSort(SortArrayList array){

        array.Counter = System.currentTimeMillis();

        for (int i = 0; i < array.list.size(); i++){
            for (int g = i; g < array.list.size(); g++){
                if (array.list.get(i) < array.list.get(g)){
                    int box = array.list.get(g);
                    array.list.set(g, array.list.get(i));
                    array.list.set(i, box);
                }
            }
        }

        array.Counter = System.currentTimeMillis() - array.Counter;
        System.out.println("Время сортировки - " + array.Counter + "ms.");
    }

    static void CocktailSort (SortArrayList array) {
        array.Counter = System.currentTimeMillis();
        int left = 0; // левая граница
        int right = array.list.size() - 1; // правая граница
        int CocktailBox = 0; // буфер для обмена

        do {
            //Сдвигаем к концу массива "тяжелые элементы"
            for (int i = left; i < right; i++)
            {
                if(array.list.get(i) > array.list.get(i+1)) {
                    CocktailBox = array.list.get(i+1);
                    array.list.set(i + 1, array.list.get(i));
                    array.list.set(i, CocktailBox);
                }
            }
            right--; // уменьшаем правую границу
            //Сдвигаем к началу массива "легкие элементы"
            for (int i = right; i > left ; i--) {
                if(array.list.get(i) < array.list.get(i-1))
                {
                    CocktailBox = array.list.get(i);
                    array.list.set(i, array.list.get(i-1));
                    array.list.set(i-1, CocktailBox);
                }
            }
            left++; // увеличиваем левую границу
        } while (left <= right);

        array.Counter = System.currentTimeMillis() - array.Counter;
        System.out.println("Время сортировки - " + array.Counter + "ms.");
    }

    static void GnomeSort(SortArrayList array) {

        array.Counter = System.currentTimeMillis();
        int i = 1;

        while(i < array.list.size()) {
            if(i == 0 || array.list.get(i - 1) <= array.list.get(i))
                i++;
            else {
                int temp = array.list.get(i);
                array.list.set(i, i - 1);
                array.list.set(i - 1, temp);
                i--;
            }
        }

        array.Counter = System.currentTimeMillis() - array.Counter;
        System.out.println("Время сортировки - " + array.Counter + "ms.");
    }

    static void QuickSort (SortArrayList array) {

        array.Counter = System.currentTimeMillis();

        Collections.sort(array.list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.toString().compareTo(o1.toString());
            }
        });

        array.Counter = System.currentTimeMillis() - array.Counter;
        System.out.println("Время сортировки - " + array.Counter + "ms.");
    }
}
