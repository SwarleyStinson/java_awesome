package core;

public class f4_tryCatch {

    public static void main(String[] args) {
        try {
            System.out.println(method());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String method() throws Exception {
        try {
            return "RESULT !!!";
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("AFTER RETURN");
        throw new Exception();
    }
}
