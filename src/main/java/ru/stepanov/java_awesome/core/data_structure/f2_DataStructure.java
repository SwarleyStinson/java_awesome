package ru.stepanov.java_awesome.core.data_structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class f2_DataStructure {
    static int[] array = {1, 2, 3, 4, 5};
    String str = "6, 7, 8, 9";

    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    static Random random = new Random();
    static int min = 0;
    static int max = 0;

    public static void main(String[] args) {
        int avg = 0;
        for (int i = 0; i < 1000; i++) {
            int r = random.nextInt(10);
            map.put(r, map.get(r) == null ? 1 : map.get(r) + 1);
        }

        // find MIN and MAX
        // sort
        Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry + " ");
            max = max < entry.getValue() ? entry.getValue() : max;
            min = min > entry.getValue() || min == 0 ? entry.getValue() : min;

            sortedMap.put(entry.getValue(), entry.getKey());
        }

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            System.out.print("\n" + entry.getKey() + " = " + entry.getValue());
        }

        System.out.println();
        System.out.println("MINIMUM: " + min);
        System.out.println("MAXIMUM: " + max);
        System.out.println("РАЗНИЦА: " + (max - min));
    }
}
