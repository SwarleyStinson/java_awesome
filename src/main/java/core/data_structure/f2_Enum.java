package core.data_structure;

import javax.xml.bind.annotation.XmlEnumValue;

enum f2_Enum {
    @XmlEnumValue("jcb")
    ONE,
    SECOND,
    THIRD;

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


        f2_Enum valueOf = f2_Enum.valueOf("jcb");
        System.out.println(1);

        System.out.println("merchantId");
    }
}
