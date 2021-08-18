package ru.stepanov.java_awesome.core;

public class f1_dataType {
    /**
     * 8 типов
     */
    static byte b; // 1 байт    от -128 до 127
    static short s; // 2 байта  от -32_768 до 32_767
    static int i; // 4 байта    от -2_147_483_648 до 2_147_483_647
    static long l; // 8 байт    от -9_223_372_036_854_775_808 до 9_223_372_036_854_775_807

    static float f; // 4 байта, вещественные числа   от ~1,4*10-45 до ~3,4*10+38
    static double d; // 8 байт, вещественные числа   от ~4,9*10-324  до ~1,8*10+308

    static char c; // 2 байта, символ Unicode   от ‘\ u0000’ (или 0), до ‘\ uffff’ (или 65535)
    static boolean bool;

    /**
     * Переменные
     */
    final static transient int maxSpeed = 0;

    /* transient  - Эта переменная не будет участвовать в сериализации
     *  volatile - операция чтения/запись является атомарной. Эта переменная видна другим потокам.
     *  final - помечает поле, как константу, которой нужно сразу задать значение.
     *  static - это переменная класса.
     *          Её можно использовать без создания объекта класса.
     *          Она одна на весь класс, и не зависит от количества объектов данного класса.
     *
     * */

    public static void main(String[] args) {

        /** Value by default !
         * */
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println("'" + c + "'");
        System.out.println(bool);

        System.out.println(Boolean.getBoolean("true"));
        System.out.println(Boolean.getBoolean("TRue"));
        System.out.println(Boolean.getBoolean("1"));
        System.out.println(Boolean.valueOf("true"));
        System.out.println(Boolean.valueOf("trUE"));
        System.out.println(Boolean.valueOf("1"));
        System.out.println(Boolean.valueOf(null));
        System.out.println(Boolean.getBoolean(null));

        System.out.println(1.03 - 0.42);
    }
}
