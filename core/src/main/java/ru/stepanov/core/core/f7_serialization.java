package ru.stepanov.core.core;

import java.io.*;

public class f7_serialization {
    /** static поля не сериализуются */

    static class User implements Serializable {
        int level;

        /** transient-поля не участвуют в сериализации */
        transient Object object;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.level = 55;
        user.object = "transient";

        FileOutputStream fileOutputStream = new FileOutputStream("temp");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User newUser = (User) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(newUser.level);
    }
}

