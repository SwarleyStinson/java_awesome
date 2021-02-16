package ru.stepanov.java_awesome.awt;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameLauncher {

    /**
     * https://habr.com/ru/post/434218/
     * */

    public static void main(String[] args) {
        String application = "D:/app/Icecream Ebook Reader/ebookreader.exe";
        File file = new File(application);
        //commit 1
        //commit 2
        //commit 3
        //commit must be unpushed
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
