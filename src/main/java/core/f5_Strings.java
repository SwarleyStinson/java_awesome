package core;

import java.util.Random;

public class f5_Strings {
    static String string = "The new String";

    /**
     * Error:(7, 28) java: non-static variable string cannot be referenced from a static context
     */

    public static void main(String[] args) {
        // ArrayList<String> array = new ArrayList<>();
        String str = " test space ";
        System.out.println(str.trim());
        System.out.println(str.endsWith(" "));
        System.out.println(str.trim().endsWith(" "));

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