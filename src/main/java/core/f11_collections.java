package core;

import java.util.*;

public class f11_collections {
    public static void main(String[] args) {
        // TODO: прочитать
        /** интерфейс Collection
         * .add()
         * .iterator()
         * */
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        collection.add(3);

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Object j : collection) {
            System.out.println(j);
        }

        /** интерфейс List
         * *              и его реализации ArrayList
         * *                               LinkedList
         * .set()
         * .get()
         * .indexOf()
         * */
        List list1 = new Vector();
        ArrayList list2 = new ArrayList();
        list2.add("param1");
        list2.add("param2");
        System.out.println("ArrayList contains param1: " + list2.contains("param3"));
        LinkedList linkedList = new LinkedList();

        /** интерфейс Set
         * *             и его реализации HashSet
         * *                              TreeSet
         * *                              EnumSet
         * *                              LinkedHashSet
         * */
        Set set = new HashSet();

        /** интерфейс Queue
         * *               и его реализации ArrayDeque
         * *                                PriorityQueue
         * */
        Queue queue = new ArrayDeque();
        PriorityQueue priQueue = new PriorityQueue();

        Collections collections;
        Arrays arrays;

        Map<String, String> map = new HashMap<>();
        map.put("param1","value1");
        map.put("param2","value2");
        System.out.println(map.toString());
    }
}
