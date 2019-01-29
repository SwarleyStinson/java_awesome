package core;

public class f_GarbageCollector {
    public static void main(String[] args) {
        System.out.println("Call Garbage collector");

        long nano = System.nanoTime(), millis = System.currentTimeMillis();

        System.gc();

        System.out.println("nano=" + (System.nanoTime() - nano) +
                "\nmillis=" + (System.currentTimeMillis() - millis));
    }

    // TODO: урок 34 garbage collector. Наверно, там будет что-то интересное
}
