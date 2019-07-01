package core.datastructure;

import java.util.Map;

public class ConcurrentHashMap {

    public static void main(String[] args) {
        Map<String, String> map = new java.util.concurrent.ConcurrentHashMap<>();

        String value = map.putIfAbsent("key1", "param1");

        String s = map.putIfAbsent("key1", "param2");

        System.out.println(1);
    }
}
