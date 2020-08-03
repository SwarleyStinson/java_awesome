package core.data_structure;

import lombok.AllArgsConstructor;
import lombok.val;

import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

public class Set {
    public static void main(String[] args) {
        val set = new HashSet<>();
        set.add("value_1");
        set.add("value_2");
        set.add("value_1");
        System.out.println(set);

        //HashSet и важность переопределения equals и hashcode
        val people = new HashSet<>();
        people.add(new Person("Ivan", 10));
        people.add(new Person("Ivan", 11));
        people.add(new Person("Ivan", 11));
        people.add(new Person("Ivan", 12));
        System.out.println(people);
        val pers = new Person("Ivan", 12);
        System.out.println("TRYING REMOVE: " + pers);
        people.remove(pers);
        System.out.println("After removing: " + people);

        //SortedSet и важность сортировки
        val treeSet = new TreeSet<Person>();
//        treeSet.add();

    }


    @AllArgsConstructor
    static class Person implements Comparable {
        String name;
        int age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return name + " " + age;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Person) {
                return ((Person) o).age - this.age;
            }
            return 0;
        }
    }
}
