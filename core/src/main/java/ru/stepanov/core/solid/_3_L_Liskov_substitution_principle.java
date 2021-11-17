package ru.stepanov.core.solid;

import lombok.Getter;
import lombok.Setter;

public class _3_L_Liskov_substitution_principle {
    /**
     * "функция, использующая ссылку на базовый класс, должна уметь использовать производный (без понимания, что это производный)"
     * При наследовании мы не должны изменять поведение родителя.
     */

    public static void main(String[] args) {
        calculateArea_test(new Rectangle());
        calculateArea_test(new Square());
    }

    static void calculateArea_test(Rectangle r) {
        r.setWidth(2);
        r.setLength(3);
        if (r.getArea() != 6) printError("area", r);
        if (r.getLength() != 3) printError("length", r);
        if (r.getWidth() != 2) printError("width", r);
    }

    private static void printError(String errorIdentifer, Rectangle r) {
        System.out.println("Unexpected value of " + errorIdentifer + "  for instance of " + r.getClass().getName());
    }

    @Getter
    @Setter
    static class Rectangle {
        private int length;
        private int width;

        int getArea() {
            return this.length * this.width;
        }
    }

    static class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            super.setWidth(width);
            super.setLength(width);
        }

        @Override
        public void setLength(int length) {
            super.setLength(length);
            super.setWidth(length);
        }
    }
}
