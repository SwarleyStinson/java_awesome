package ru.stepanov.core.solid;

public class _1_S_single_responsibility_principle {
    /**
     * Класс должен иметь только одну причину для изменения.
     * */

    class Employee{
        int getSakary(){
            return 10;
        }
//        void cook(){
//
//        }
//        void cleanFloor(){
//
//        }
    }

    class Cook {
        void cook(){
        }
    }

    class Janitor {
        void cleanFloor(){

        }
    }

}
