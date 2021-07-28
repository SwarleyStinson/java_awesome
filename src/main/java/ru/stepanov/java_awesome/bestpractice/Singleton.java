package ru.stepanov.java_awesome.bestpractice;

import java.io.Serializable;

/**
 * Класс, который будет единственным в своем экземпляре.
 * * т.е. мы не сможем создать другой экземпляр такого класса.
 * *
 * На сегодня это АНТИ-паттерн.
 * *    п.ч. его не удобно тестировать: TODO: проверить нельзя создать мок-объект.
 */
public class Singleton implements Serializable {

    enum MySingleton {
        INSTANCE;
    }

    /**
     * 2 подхода к созданию синглтона: public ПЕРЕМЕННАЯ или public МЕТОД.
     * *
     * 1) PUBLIC static final Singleton singleton = new Singleton();
     * *
     * 2) Более гибкий.
     * *  private static final Singleton singleton = new Singleton();
     * *  PUBLIC static Singleton getInstance() {
     * *      return singleton;
     * *  }
     */
    private static final Singleton singleton = new Singleton();

    private Singleton() {
    }

    //approaches
    //advahtages
    //serializible
    //enum
    public static void main(String[] args) {
        /**
         * Вызывая эти методы по очереди, кажется, что они не взаимосвязаны.
         * Но 1 метод может, например, set-ить поля, которые повлияют на работу второго.
         * Это НЕЯВНО !!!
         * */
        singleton.someMethod();
        singleton.someOtherMethod();

        /**
         * Если наш Singleton сделают implements Serializible,
         * * то при сериализации смогут получить еще один экземпляр. А этого мы хотели избежать, когда делали синглтон!
         * *
         * Решение !!! : переопределить метод readResolve():
         * *    private Object readResolve() {
         * *        return singleton;
         * *    }
         * */

        /**
         * Б.т. вызвать приватный метод можно через рефлексию, т.е. создать еще один экземпляр !
         * *
         * Решение для защиты от таких "хаков" (сериализация, рефлексия...):
         * *    использование enum'ов.
         * */
    }

    private void someOtherMethod() {

    }

    private void someMethod() {

    }
}
