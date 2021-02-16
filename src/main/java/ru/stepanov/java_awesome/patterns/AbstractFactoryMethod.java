package ru.stepanov.java_awesome.patterns;

public class AbstractFactoryMethod {

}

class Pattern {

    private Pattern() {
    }

    public Pattern create(){
        return new Pattern();
    }
}
