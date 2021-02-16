package ru.stepanov.java_awesome.core;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class f11_collectionsComparing {

    /**
     * для сортировки непримитивных коллекций в коллекции, нужно объяснить JVM как сравнивать
     * *                                       ->  реализовать интерфейс Comparable, переопределив метод toCompare()
     */
    static class Person implements Comparable<Person> {
        int age;

        public Person(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    "}";
        }

        @Override
        public int compareTo(Person p) {
            return this.age - p.age;
        }
    }

    public static void main(String[] args) {
//        ComparePerson comparePerson = new ComparePerson();
//        Set set = new TreeSet(comparePerson);
//        Set set = new TreeSet(new ComparePerson());
        Set set = new TreeSet();


        set.add(new Person(8));
        set.add(new Person(2));
        set.add(new Person(6));
        set.add(new Person(1));
        for (Object o : set) {
            System.out.println(o);
        }
    }

    /**
     * Если не можем изменить исходный код Person, то есть Comparator.
     */
    static class ComparePerson implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.age - o2.age;
        }
    }

}
