package ru.stepanov.core.concurrency;

class Singleton {
    /**
     * JUST DO IT
     */
    public static final Singleton instance_1 = new Singleton();

    /**
     * ENUM
     */
    enum Singleton_2 {
        INSTANCE;
    }

    /**
     * LAZY:  double-checked  &&  volatile
     */
    private volatile Singleton instance;

    Singleton getSingleton_3() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * LAZY: on-demand HOLDER idiom
     */
    public static class SingletonHolder {
        public static final Singleton HOLDER_INSTANCE = new Singleton();
    }
    Singleton getSingleton_4() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
