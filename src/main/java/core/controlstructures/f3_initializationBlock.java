package core.controlstructures;

class Parent {
    static {
        System.out.println("parent static init block");
    }

    {
        System.out.println("parent init block");
    }

    Parent() {
        System.out.println("parent constructor");
    }
}

public class f3_initializationBlock extends Parent {

    static {
        System.out.println("static init block");
    }

    public f3_initializationBlock() {
        System.out.println("constructor");
    }

    {
        System.out.println("init block");
    }

    {
        System.out.println("init block2");
    }

    public static void main(String[] args) {
        new f3_initializationBlock();
    }

    {
        System.out.println("init block3");
    }
}

