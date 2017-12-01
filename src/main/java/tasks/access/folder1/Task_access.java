package tasks.access.folder1;

import tasks.Task_1;

public class Task_access {
    public Task_access() {
        this.var1 = 11;
        this.var2 = 22;
        this.var3 = 33;
        this.tsk = new Task_1();
    }

    Task_1 tsk;

    public Integer var1;
    protected Integer var2;
    private Integer var3;

    public Integer getVar1() {
        return 10;
    }

    protected Integer getVar2() {
        return 10;
    }

    private Integer getVar3() {
        return 10;
    }
}
