package ru.stepanov.core.core8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

public class OptionalClass {

    public static void main(String[] args) {
        User user1 = new User("John", new Address("USA"), 9);
        User user2 = new User("Jack", null, 18);

        Map<String, String> map1 = null;
        Map<String, String> map2 = new HashMap<>();

        ofNullable(map1).orElse(new HashMap<>());
        ofNullable(map2).orElseThrow(RuntimeException::new);
        ofNullable(map2).filter(f -> f.size() > 0);
        ofNullable(user2).map(User::getName).get();

        System.out.println(format("%s is %s", user1.getName(), isRussianArmyRecrute(user1) ? "soldier" : "free man"));
        System.out.println(format("%s is %s", user2.getName(), isRussianArmyRecrute(user2) ? "soldier" : "free man"));

        Optional<Address> address = getAddress();
        System.out.println(1);
    }

    private static boolean isRussianArmyRecrute(User user) {
        return ofNullable(user)
                .map(User::getAge)
                .filter(p -> p >= 18)
                .filter(p -> p <= 27)
                .isPresent();
    }

    @AllArgsConstructor
    static @Data
    class User {
        String name;
        Address address;
        int age;

    }
    @AllArgsConstructor
    static @Data
    class Address {
        String country;

    }

    private static Optional<Address> getAddress(){
        return ofNullable(null);
    }
}
