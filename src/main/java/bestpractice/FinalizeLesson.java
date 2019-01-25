package bestpractice;

public class FinalizeLesson {
    public static void main(String[] args) {
        /** DON't USE IT !!!.
         * *       медленно работает
         * *       не факт , что запуститься
         * *
         * если use, то только для логирования.
         * */
    }

    /* в сети рекомендуют */
    @Override
    protected void finalize() throws Throwable {
        try {
            // do something, f.e. logging.
        } finally {
            super.finalize();
        }
    }

    /* но, для защиты от дурака, лучше использовать
    * * так мы точно гарантируем выполнение finalize, п.ч. когда запускается finalize для outer-класса,
    * *                                                    то он запускается и для inner-класса.
    * */
    private final Object finalizerGuardian = new Object() {
        @Override
        protected void finalize() throws Throwable {
            //  do something, f.e. logging.
        }
    };

}
