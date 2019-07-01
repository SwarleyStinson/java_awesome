package core.controlstructures;

import java.util.HashMap;

public class f4_ifElseSwitch {
    public static void main(String[] args) {

        int i = 5;

        if (i==5){
            try {
                throw new RuntimeException("");
            } catch (Exception e){
                System.out.println("CATCH");
            }
        }

        System.out.println("AFTER");
    }
}
