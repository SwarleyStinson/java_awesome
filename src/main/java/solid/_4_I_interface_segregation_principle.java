package solid;

public class _4_I_interface_segregation_principle {
    /**
     * Нужно декомпозировать интерфейсы !!!
     * *
     * Не должно быть такой ситуации, что класс реализует интерфейс,
     * но не реализует все методы этого интерфейса.
     * */
    public static void main(String[] args) {

    }
}

interface Worker {
    void work();
}
interface Eater{
    void eat();
}

interface IWorker extends Worker, Eater{
}

class Cook implements IWorker {
    @Override
    public void work() {
        System.out.println("work");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}

class Student implements Worker{
    @Override
    public void work() {

    }
}

