package core.java8core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        list.add(new A("field1", new ArrayList<>()));
        list.add(new A("field2", null));

        List<A> collect = list.stream()
                .filter(t -> t.field.startsWith("field1"))
                .filter(t -> {
                    System.out.println(t.field);
                    t.list.size();
                    t.field.equals("field2");
                    return true;
                })
                .collect(Collectors.toList());
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
