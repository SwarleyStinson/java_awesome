package ru.stepanov.core.core;

public class f1_dataType {
    /**
     * 8 типов
     */
    static byte _byte; // 1 байт    от -128 до 127
    static short _short; // 2 байта  от -32_768 до 32_767
    static int _int; // 4 байта    от -2_147_483_648 до 2_147_483_647
    static long _long; // 8 байт    от -9_223_372_036_854_775_808 до 9_223_372_036_854_775_807

    static float _float; // 4 байта, вещественные числа   от ~1,4*10-45 до ~3,4*10+38
    static double _double; // 8 байт, вещественные числа   от ~4,9*10-324  до ~1,8*10+308

    static char _char; // 2 байта, символ Unicode   от ‘\ u0000’ (или 0), до ‘\ uffff’ (или 65535)
    static boolean _boolean;

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
        System.out.println(_byte);
        System.out.println(_short);
        System.out.println(_int);
        System.out.println(_long);
        System.out.println(_float);
        System.out.println(_double);
        System.out.println("'" + _char + "'");
        System.out.println(_boolean);

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
