package ru.stepanov.java_awesome.bestpractice;

import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StaticFactory {
    public static void main(String[] args) throws SQLException {
        //examples
        BigInteger bigInteger1 = new BigInteger(1, 2, new Random());
        BigInteger bigInteger2 = BigInteger.probablePrime(1, new Random());
        DriverManager.getConnection("");

        Car.getSportCar();
    }
}

class Car {
    String color;
    int doors;

    private static Map<String, Car> cashe = new HashMap<String, Car>();

    private Car(String color) {
        this.color = color;
    }

    private Car(int doors) {
        this.doors = doors;
    }

    public Car() {
    }

    /**
     * Это и есть СТАТИЧЕСКИЙ FACTORY-метод.
     * *
     * Зачем использовать, когда есть конструктор?
     * *       удобнее, если конструкторов стало много.
     * *
     * 1) Преимущество в имени !!!
     * *     factory-метод можно назвать как обычный java-метод. В отличии от конструктора, чье имя = имени класса.
     * *    Будет ИНТУИТИВНО понятно, какой "конструктор" использовать, и какой объект вернется,
     * *                                                                      т.е., например, какие поля будут заполнены.
     * *
     * 2) Преимущество в создании своего "кэша":
     * *      вызов конструктора = создание нового объекта.
     * *      Можно хранить уже созданные объекты в некой структуре, называемой, например, cache,
     * *                и возвращать ссылку на уже существующий объект, чтобы не создавать новый.
     * *
     * 3) Наследование. Можно создать внутренний класс, например, Ferrari, и возвращать его.
     * *
     */
    public static Car getWhiteCar(String color) {
        if (cashe.containsKey(color)) {
            return cashe.get(color);
        }
        /*...*/
        return new Car(color);
    }

    public static Car getSportCar() {
        /*...*/
        return new SportCar(2);
    }

    static class SportCar extends Car {
        SportCar(int doors) {
            super(doors);
        }
    }
}



