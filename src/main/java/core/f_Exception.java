package core;

public class f_Exception {
    public static void main(String[] args) throws Exception {
        HandledException exc = new HandledException();

        for (int i = 0; i < 10; i++) {
//            System.out.print(exc.getSome(i) + " ");

            System.out.println(exc.getThing(i));
        }
    }

    static class HandledException {
        String getSome(int param) {
            if (param == 5) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    return "exception happened!!";
                }
            }
            return "result";
        }

        String getThing(int param) throws Exception {
            if (param == 5) {
                throw new Exception();
            }
            return "result";
        }
    }
}
