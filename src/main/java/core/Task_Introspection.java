package core;

public class Task_Introspection {
    public static class Color {
        String intencity = "max";
    }

    public static class Yellow extends Color {
        String type = "submarine";
    }


    public static void main(String[] args) {

        /** Introspection in JAVA */

        Color color = new Color();
        Yellow yellow = new Yellow();

        /** 1. INSTANCEOF */
        System.out.println(color instanceof Color);  // true
        System.out.println(yellow instanceof Color); // true   ----|  потому что "восходящее преобразование"
        System.out.println(color instanceof Yellow); // false      |  т.е. каждый объект воспринимается
        System.out.println(color instanceof Object); // true   ----|  как ссылка на своего родителя

        /** 2. Object.getClass() and Class.getName() */
        System.out.println(color.getClass());
        System.out.println(yellow.getClass());
        System.out.println("class NAME =>" + color.getClass().getName());
        System.out.println("class CANONICAL_NAME =>" + color.getClass().getCanonicalName());
        System.out.println("class SimpleName =>" + color.getClass().getSimpleName());
        System.out.println("class TypeName =>" + color.getClass().getTypeName());
    }
}
