package core;

public class f_Strings {
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
        System.out.println(String.format("Число %n", 25));
    }
}
