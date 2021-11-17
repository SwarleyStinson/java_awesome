package ru.stepanov.core.core;

import java.util.Random;

public class f5_Strings {
    /**
     * String pool -
     * *            JVM can optimize the amount of memory allocated for String
     * *            by storing only one copy of each literal String in the pool.
     * *
     * When we create a String variable and assign a value to it, the JVM searches the pool for a String of equal value.
     * *
     * If found, the Java compiler will simply return a reference to its memory address,
     * without allocating additional memory.
     * *
     * If not found, it’ll be added to the pool (interned) and its reference will be returned.
     */
    static String string = "The new String";
    String s1;
    String s2;
    String s3;
    String s4;

    {
        s1 = "literal"; // will create new value in String pool
        s2 = new String("new object in heap");
        /*
           will NOT create new value, because String pool conclude this literal   ->  more fast, cheap for memory
         */
        s3 = "literal";
        /*
            NO creating new value, using existing literal.
        */
        s4 = s2.intern();
    }

    /**
     * Error:(7, 28) java: non-static variable string cannot be referenced from a static context
     */

    public static void main(String[] args) {
        // ArrayList<String> array = new ArrayList<>();
        String str = " test space ";
        System.out.println(str.trim());
        System.out.println(str.endsWith(" "));
        System.out.println(str.trim().endsWith(" "));

        f5_Strings thisClass = new f5_Strings();
        System.out.println("s1 == s2: " + String.valueOf(thisClass.s1 == thisClass.s3));


        str = "deudirectbanking";
        System.out.println(str.substring(0, str.indexOf("direct")));

        /** изменение String = создание новой строки
         * StringBuilder   или   StringBuffer
         * */

        Random random = new Random();

        long begin = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder("string");
        for (int i = 0; i < 1_000_000; i++) {
            builder.replace(1, 2, String.valueOf(random.nextInt()));
//            str = "String" + random.nextInt();
        }
        System.out.println(System.currentTimeMillis() - begin);

    }

    static String deleteSpaces(String str) {
        if (str.contains(" ")) {
            str = str.substring(0, str.indexOf(" ")) + str.substring(str.indexOf(" ") + 1, str.length());
            str = deleteSpaces(str);
        }
        return str;
    }

    void stringTest() {
        System.out.println(string.charAt(5));
        System.out.println(String.valueOf(25));
        System.out.println(String.format("Число %d", 25));
    }
}
