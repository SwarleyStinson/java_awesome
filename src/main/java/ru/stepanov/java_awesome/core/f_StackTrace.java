package ru.stepanov.java_awesome.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class f_StackTrace {

    final Logger LOGGER = LoggerFactory.getLogger("f_StackTrace");

    public static void main(String[] args) throws Exception {

        GalaxyMarine marine = new GalaxyMarine();
        marine.createStarship(150);
    }

    static class GalaxyMarine {
        void createStarship(Integer number) throws Exception {
            System.out.println("Enterprice CX" + number + "\n");
            createCommand("command");
        }

        void createCommand(String str) throws Exception {
            createMember("Spock");
            createMember("McKoy");
            createMember("Scotty");
            createMember("Captain James Tibery Kirk");
        }

        void createMember(String name) throws Exception {
            System.out.print(name + " was added to your command !");
            try {
                throw new Exception();
            } catch (Exception e) {
                // LOGGER.warn("test exception logger");
                e.printStackTrace();
            }

            int[] scores = {12, 34};



        }
    }



}
