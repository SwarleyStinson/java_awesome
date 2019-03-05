package solid;

public class _2_O_openClosed_principle {
    /**
     * Каждый модуль должен быть ОТКРЫТ для расширений,
     * но ЗАКРЫТ для модификаций.
     * *
     * Нужно всегда think о расширении.
     * */

    public static void main(String[] args) {
//        Toyota toyota = new Toyota();
        Selica selica = new Selica();
        workInTaxi(selica);
    }
    static void workInTaxi(Car car){
        car.workInTaxi();
    }
}

interface Car {
    void workInTaxi();
}

class Toyota implements Car {
    @Override
    public void workInTaxi() {
        System.out.println("get 4 passangers");
    }
}
class Selica implements Car {
    @Override
    public void workInTaxi() {
        System.out.println("get one passanger");
    }
}
