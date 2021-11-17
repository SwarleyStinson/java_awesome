package ru.stepanov.core.core;

import java.lang.reflect.*;

public class f14_reflexion {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SomeClass someClass = new SomeClass();
        Class class1 = someClass.getClass();
        Class class2 = SomeClass.class;
        Class class3 = Class.forName("ru.stepanov.core.core.f14_reflexion");

        SomeClass someClass1 = (SomeClass) class1.newInstance();

        Constructor[] constructors = class1.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName());
            Parameter[] parameters = c.getParameters();
            for (Parameter p : parameters) {
                System.out.println(p.getName());
                System.out.println(p.getType().getName());
            }
        }

        System.out.println("\nMethods");
        Method[] methods = class1.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
            Parameter[] parameters = m.getParameters();
            for (Parameter p : parameters) {
                System.out.println(p.getName());
                System.out.println(p.getType().getName());
            }
        }

        System.out.println("\nFields");
        Field[] fields = class1.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
            System.out.println(f.getType().getName());
            System.out.println(Modifier.toString(f.getModifiers()));
            f.setAccessible(true);
            f.setInt(someClass, 5);
            System.out.println(f.getInt(someClass));
        }
    }
}

class SomeClass {
    private int i;
    String s;

    public SomeClass() {
    }

    public SomeClass(String s) {
        this.s = s;
    }

    public String someMethod(String s) {
        System.out.println("this is " + s);
        return s;
    }
}

