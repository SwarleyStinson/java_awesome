package ru.stepanov.java_awesome.java8core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
        Map<String, String[]> map = new HashMap<>();
        map.put("param1", new String[]{"value1"});
        map.put("param2", new String[]{"value2"});
        map.put("param3", new String[]{"value3"});

        Map<String, String> result = map.entrySet().stream()
                .collect(Collectors.toMap(x -> x.getKey(), x -> (x.getValue())[0]));
        System.out.println(1);
    }
}

class A {
    String field;
    List<String> list;

    public A(String field, List<String> list) {
        this.field = field;
        this.list = list;
    }

    public A() {
    }
}
