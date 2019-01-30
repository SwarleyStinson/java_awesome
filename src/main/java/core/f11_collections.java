package core;

import java.util.*;

public class f11_collections {
    public static void main(String[] args) {
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
        ArrayList list = new ArrayList();
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
    }
}
