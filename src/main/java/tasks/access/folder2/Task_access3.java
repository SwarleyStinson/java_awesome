package tasks.access.folder2;

import tasks.access.folder1.Task_access;

public class Task_access3 extends Task_access{
    static class ChildTaskAccess extends Task_access {
    }

    public static void main(String[] args) {
        Task_access access = new Task_access();

        System.out.println("Доступны только public поля, анпример, var1=" + access.var1);
        System.out.println("И public методы, например, getVar1() ->" + access.getVar1());
        //  System.out.println(access.var2);  Потому что PROTECTED - доступна для пакета и наследников.
        //  System.out.println(access.getVar2);  Потому что PROTECTED - доступна для пакета и наследников.

        System.out.println();
    }
}
