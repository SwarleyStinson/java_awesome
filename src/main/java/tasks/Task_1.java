package tasks;

public class Task_1 {
    public static void main(String[] args) {
        say(Phrase.HELLO_WORLD);
        Say say = new Say(Phrase.WHATSUP);
        say(say.getPhrase());
        say.setPhrase(Phrase.GOODBY_WORLD);
        say(say.getPhrase());
    }

    static void say(Phrase phrase) {
        System.out.println(phrase);
    }

    enum Phrase {
        HELLO_WORLD, GOODBY_WORLD, WHATSUP
    }

    static class Say {
        String str;
        static String str2;

        Say(Phrase phrase) {
            this.phrase = phrase;
        }

        public Phrase phrase;

        Phrase getPhrase() {
            return phrase;
        }

        void setPhrase(Phrase phrase) {
            this.phrase = phrase;
        }
    }

    static class Song {
        static String str = "";
    }
}
