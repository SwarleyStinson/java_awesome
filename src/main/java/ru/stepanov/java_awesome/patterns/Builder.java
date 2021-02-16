package ru.stepanov.java_awesome.patterns;

import java.util.HashMap;

public class Builder {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "val1");
        OrderDataUpdate.builder()
                .fields(map)
                .build();
    }
}
