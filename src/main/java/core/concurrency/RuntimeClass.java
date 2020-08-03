package core.concurrency;

import java.util.ArrayList;
import java.util.List;

public class RuntimeClass {
    public static void main(String[] args) {
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        long freememory = Runtime.getRuntime().freeMemory() / 1024;
        System.out.println("Free memory: " + freememory + " kB");

        List list = new ArrayList();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(new HappensBefore());
        }

        System.out.println("Created " + list.size() + " objects");
        System.out.println("Current free memory: " + Runtime.getRuntime().freeMemory() + " kB");
        System.out.println("Difference: " + (freememory - Runtime.getRuntime().freeMemory() / 1024) + " kB");

        Runtime.getRuntime().gc();
        System.out.println("Difference after GC call attempt: " + (freememory - Runtime.getRuntime().freeMemory() / 1024) + " kB");

        list = null;
//        Runtime.getRuntime().gc();
        System.gc();
        System.out.println("Difference after Second GC call attempt: " + (freememory - Runtime.getRuntime().freeMemory() / 1024) + " kB");

    }
}
