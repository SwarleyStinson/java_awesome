package core.controlstructures;

public class f4_tryCatch {

    public static void main(String[] args) {
        System.out.println(method());
    }

    private static String method() {
        try {
            throw new MyException("БРОСАЮ ИСКЛЮЧЕНИЕ...");
        } catch (Exception e) {
            System.out.println("ПЕРЕХВАТИЛ !");
        } finally {
            System.out.println("FINALLY");
        }
        System.out.println("AFTER CATCH");

        return "return STRING";
    }
}

class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
        System.out.println(message);
    }
}

