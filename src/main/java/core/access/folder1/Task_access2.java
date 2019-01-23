package core.access.folder1;

public class Task_access2 {

    public static void main(String[] args) {
        Task_access access = new Task_access();

        System.out.println(access.var1);
        System.out.println(access.getVar1());
        /**
         * PROTECTED доступны в пакете.
         */
        System.out.println(access.var2);
        System.out.println(access.getVar2());
    }
}
