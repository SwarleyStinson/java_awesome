package ru.stepanov.java_awesome.javaPackages.net;

import java.net.MalformedURLException;

public class URL {
    public static void main(String[] args) throws MalformedURLException {
        String testUrl = "http://localhost.com?param={param}";

        java.net.URL url = new java.net.URL(testUrl);
        System.out.println(1);
    }
}
