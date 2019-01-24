package bestpractice;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Избегай многократного создания объектов !!!
 * Тем более если это один и тот же объект, который можно вынести в static константу.
 */
public class UnnesseccaryObjects {
    public static void main(String[] args) {
//        String str = new String("string"); //wrong!!
//        String str2 = "string";

        /**
         * Создание объекта - дорого !!!
         * */

        /* 1 */
//        long begin = System.currentTimeMillis();
//        /*
//           Long sum = 0L;  -  8s 280ms
//           long sum = 0L;  -     818ms
//        */
//        long sum = 0L;
//        for (long i = 0; i < Integer.MAX_VALUE; i++) {
//            sum += 1;
//        }
//        System.out.println(sum);
//        System.out.println(System.currentTimeMillis() - begin);

        /* 2 */
        UnnesseccaryObjects unnesseccaryObjects = new UnnesseccaryObjects();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            unnesseccaryObjects.isBabyBoomer(new Date());
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    /**
     * Плохо, п.ч многократное создание объектов.
     * *    boomStart и boomEnd не изменяются, значит достаточно их инициализировать однажды!
     * */
//    private boolean isBabyBoomer(Date birthDate) {
//        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
//        Date boomStart = gmtCal.getTime();
//        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
//        Date boomEnd = gmtCal.getTime();
//        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
//    }

    private static final Date BOOM_START;
    private static final Date BOOM_END;
    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }
    public boolean isBabyBoomer(Date birthDate){
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }

}
