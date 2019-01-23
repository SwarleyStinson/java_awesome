package excercises;

public class Excercise_3 {

    /**
     *
     * */
    static String tabu = "bullsheet";
    static String reply = "beaty";

    public static void main(String[] args) {
        StringBuilder test = new StringBuilder("This is bullsheet! Real bullsheet!!");

        System.out.println(check(test));
    }

    static String check(StringBuilder sb) {
        if (sb.toString().contains(tabu)) {
            while (sb.toString().contains(tabu)) {
                sb.insert(sb.indexOf(tabu), reply);
                sb.delete(sb.indexOf(tabu), sb.indexOf(tabu) + tabu.length());
            }
            return sb.toString();
        } else {
            return sb.toString();
        }
    }
}
