package core.controlstructures;

public class f4_operators {
    public static void main(String[] args) {
        /** + - / * % */

        int a = 60;	/* 60 = 0011 1100 */
        int b = 13;	/* 13 = 0000 1101 */
        int c = 0;

        // побитовое И
        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c );

        // побитовое ИЛИ
        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c );

        // побитовое логическое или XOR
        c = a ^ b;       /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c );

        //побитовое дополнение - "отражение" бит
        c = ~a;          /*-61 = 1100 0011 */
        System.out.println("~a = " + c );

        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c );

        c = a >> 2;     /* 215 = 1111 */
        System.out.println("a >> 2  = " + c );

        c = a >>> 2;     /* 215 = 0000 1111 */
        System.out.println("a >>> 2 = " + c );
    }
}
