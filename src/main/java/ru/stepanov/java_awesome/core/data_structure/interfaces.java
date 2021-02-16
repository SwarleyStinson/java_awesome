package ru.stepanov.java_awesome.core.data_structure;

public class interfaces {

    public static void main(String[] args) {
        Animal animal;
    }

    interface Animal{
        void live();
    }

    class Cat implements Animal {
        @Override
        public void live() {
            System.out.println("Cat alive");
        }
    }

    class Dog implements Animal {
        @Override
        public void live() {
            System.out.println("Dog alive");
        }
    }


}
