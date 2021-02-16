package ru.stepanov.java_awesome.patterns;

public class FactoryPattern {
    public static void main(String[] args) {
        Factory factory = new Factory();

        Car toyota = factory.create("Toyota");
        toyota.drive();

        Car nissan = factory.create("Nissan");
        nissan.drive();
    }
}

interface Car {
    void drive();
}

class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Toyota!");
    }
}

class Nissan implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Nissan!");
    }
}

class Factory {
    Car create(String typeOfCar) {
        switch (typeOfCar) {
            case "Toyota":
                return new Toyota();
            case "Nissan":
                return new Nissan();
            default:
                return null;
        }
    }
}
