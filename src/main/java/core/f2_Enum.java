package core;

enum f2_Enum {
    ONE, SECOND, THIRD;

    enum CoffeSize {
        SMALL(100), MEDIUM(200), BIG(300) {
            @Override
            public String getCoffeeClass() {
                return "B";
            }
        };

        String coffeeClass = "A";
        int millilitres;

        CoffeSize(int millilitres) {
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
        CoffeSize coffeSize = CoffeSize.MEDIUM;
        System.out.println(coffeSize);
        System.out.println(coffeSize.getMillilitres());
        System.out.println(coffeSize.getCoffeeClass());
    }
}
