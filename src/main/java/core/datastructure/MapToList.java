package core.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapToList {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        List<String> list = new ArrayList<>();

        /** .VALUES()  */
        list.addAll(map.values());

        System.out.println(list);
    }
}
