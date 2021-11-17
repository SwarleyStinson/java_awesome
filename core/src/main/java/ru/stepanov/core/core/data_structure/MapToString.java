package ru.stepanov.core.core.data_structure;

import lombok.var;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;

public class MapToString {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> list = new ArrayList<>();
        int size = list.size();

        list.add("");
        size = list.size();

        System.out.println(1);

    }


    private static String getHostFromUrl(String url) throws URISyntaxException {
        URI uri = new URI(url);
        var host = uri.getHost();
        if (!isNullOrEmpty(host)) {
            return host;
        }
        host = url.substring(0, url.indexOf(":"));
        return host;
    }

    private static int getPortFromUrl(String url) throws URISyntaxException {
        URI uri = new URI(url);
        var port = uri.getPort();
        if (port != -1) {
            return port;
        }
        port = tryParseInt(url.substring(url.indexOf(":") + 1, url.indexOf("/", url.indexOf(":"))));
        return port;
    }

    private static int tryParseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return -1;
        }
    }
}
