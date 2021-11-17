package ru.stepanov.core.core;

public class f14_clone {

    /**
     * По умолчанию клонирование поверхностное: клонируются ТОЛЬКО ПРИМИТИВНЫЕ поля.
     * *
     * Для клонирования ссылочных полей нужно переопределить метож clone()
     * и для каждого ссылочного поля вызвать clone().
     */

    public static void main(String[] args) throws Exception {
        MyObject myObject = new MyObject();
        myObject.i = 1;
        NewObject newObject = new NewObject();
        newObject.j = 3;
        myObject.newObject = newObject;
        MyObject myObject1 = myObject.clone();
        myObject1.i = 2;
        myObject1.newObject.j = 4;
        System.out.println(myObject.i);
        System.out.println(myObject.newObject.j);
    }

}

class MyObject implements Cloneable {
    int i;
    NewObject newObject;

    @Override
    protected MyObject clone() throws CloneNotSupportedException {
        MyObject myObject = (MyObject) super.clone();
        myObject.newObject = newObject.clone();
        return myObject;
    }
}

class NewObject implements Cloneable {
    int j;

    @Override
    protected NewObject clone() throws CloneNotSupportedException {
        return (NewObject) super.clone();
    }
}
