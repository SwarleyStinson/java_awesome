package excercises;

import java.util.Scanner;

public class Excercise_1 {


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("enter ->");
        String s = "";
        StringBuilder result = new StringBuilder();
        while (!s.equals(".")) {
            s = keyboard.nextLine();

            if (s.contains(".")) {
                System.out.println(s.indexOf("."));
                result.append(s.substring(0, s.indexOf(".")));
                s = ".";
            } else {
                result.append(s);
            }
        }

        System.out.println("result ->" + result.toString());
    }
}
