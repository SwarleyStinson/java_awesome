package core;

enum f2_Enum {
    ONE, SECOND, THIRD;

    enum CoffeeSize {
        SMALL(100), MEDIUM(200), BIG(300) {
            @Override
            public String getCoffeeClass() {
                return "B";
            }
        };

        String coffeeClass = "A";
        int millilitres;

        CoffeeSize(int millilitres) {
            this.millilitres = millilitres;
        }

        public String getCoffeeClass() {
            return coffeeClass;
        }

        public int getMillilitres() {
            return millilitres;
        }
    }

    public static void main(String[] args) {
        CoffeeSize coffeeSize = CoffeeSize.MEDIUM;
        System.out.println(coffeeSize);
        System.out.println(coffeeSize.getMillilitres());
        System.out.println(coffeeSize.getCoffeeClass());
    }
}
