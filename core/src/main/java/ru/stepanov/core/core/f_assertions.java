package ru.stepanov.core.core;

public class f_assertions {

    public static void main(String[] args) {
        new f_assertions().method(-5);
    }

    private void method(int i) {
        /** по умолчанию assert'ы ОТКЛЮЧЕНЫ */
        assert (i > 0);
        System.out.println(i);

        /**для активации нужно запускать с параметром
         *
         * java -ea f_assertions
         * */
    }
}
