package ru.stepanov.core.core;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * С generic'ом мало что можно сделать.
 * Его удобно только хранить!
 * *
 * 1) Generic'и существуют только до этапа компиляции.
 * *  После компиляции в байткоде все наши T будут заменены на Object.
 * *
 * 2) Нельзя создавать массивы generic'ов.
 * *
 * 3) Нельзя создать static generic-переменную
 */
public class f12_generics {
    public static void main(String[] args) {
        f12_generics main = new f12_generics();
        main.method(123, new ArrayList<>());

        /** Можно параметризовывать коллекции. */
        /* так будут потенциальные проблемы */
        List list = new ArrayList();
        list.add(new File(""));
        list.add(new Object());
        list.add("string");

        /* так таких проблем не будет */
        List<String> list2 = new ArrayList<>();
        list2.add("");
    }

    /**
     * Generic-метод
     * *             - который принимает/возвращает Generic-тип.
     */
    <T, U> T method(T type, List<String> list) {
        U u;
        System.out.println(type);
        return type;
    }

    /**
     * Generic-класс
     */
    class Main<T extends Math & Comparable & Serializable> {
        T var;

        T method(T type) {
            /**  var. - доступны только методы Object
             * */
            System.out.println(type);
            return type;
        }

        /*
        * <? extends Main>
        * <? super Main>   ->  здесь можно добавлять, но только тех, кто ниже по иерархии !!!
        */
        void method(List<? extends Main> main) {
            /**
             *  при использовании "<? extends Main>" в принимаемом параметре метода
             *  мы не можем ничего добавить к той структуре, т.е.
             *  *                                       List<? extends Main> main
             *  *       НЕЛЬЗЯ !!!     list.add(new Main());
             */
        }
    }
}
