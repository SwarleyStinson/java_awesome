package tasks;

public class Task_Garbage_collector {
    public static void main(String[] args) {
        System.out.println("Call Garbage collector");

        long nano = System.nanoTime(), millis = System.currentTimeMillis();

        System.gc();

        System.out.println("nano=" + (System.nanoTime() - nano) +
                "\nmillis=" + (System.currentTimeMillis() - millis));
    }
}
