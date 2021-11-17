package ru.stepanov.core.core;

class Popcorn {
    void doSomething() {
        System.out.println("popcorn");
    }
}

public class f13_anonymousClass {
    public static void main(String[] args) {
        /**
         *  Переопределить при создании объекта.
         */
        Popcorn popcorn = new Popcorn() {
            @Override
            void doSomething() {
                System.out.println("override popcorn");
            }
        };
        popcorn.doSomething();

        /** При передаче объекта в качестве параметра.*/
        method(new Popcorn() {
            @Override
            void doSomething() {
                System.out.println("override in method parameters !!!");
            }
        });

    }

    static void method(Popcorn popcorn) {
        popcorn.doSomething();
    }
}
