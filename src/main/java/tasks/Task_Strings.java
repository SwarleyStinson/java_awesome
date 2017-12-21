package tasks;

public class Task_Strings {
    static String string = "The new String";
    /** Error:(7, 28) java: non-static variable string cannot be referenced from a static context */

    public static void main(String[] args) {
        System.out.println(string.charAt(5));
        System.out.println(String.valueOf(25));
        System.out.println(String.format("Число %n", 25));
    }
}
