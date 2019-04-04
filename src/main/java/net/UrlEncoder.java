package net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(method("KJHVkvhVKHJjkhvhJhvhvjkJKHvJHvJHvJKHV"));
        System.out.println(method("asd   12e21asca saf32f2 23f32 f2"));
        System.out.println(method(null));
    }


    private static String method(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, "UTF-8");
    }
}
