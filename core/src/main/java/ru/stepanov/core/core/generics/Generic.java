package ru.stepanov.core.core.generics;

/**
 * Причина: помочь прогр-ту случ-но не положить в коллекцию объект другого типа
 * Где: этап компиляции
 */

public class Generic {

    public static void main(String[] args) {
        Cell<String> cell = new Cell<>();
    }
}

class Cell<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}