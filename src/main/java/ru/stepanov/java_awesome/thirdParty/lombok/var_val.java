package ru.stepanov.java_awesome.thirdParty.lombok;

import lombok.val;
import lombok.var;

public class var_val {
    public static void main(String[] args) {
        var param = "string_example";
        param = "new string";
        System.out.println(param);

        if (param instanceof String) {
            System.out.println("TRUE");
        }

        val finalParam = "";
        // cannot assign a value to final variable finalParam
        // finalParam = "new value";
    }
}
