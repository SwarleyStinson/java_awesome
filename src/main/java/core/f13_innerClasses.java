package core;

public class f13_innerClasses {
    class inner {
        /**
         * Не может содержать static-методы и static-переменные.
         */
    }

    public void main(String[] args) {
        f13_innerClasses outer = new f13_innerClasses();
        f13_innerClasses.inner inner = new f13_innerClasses.inner();
    }

}
