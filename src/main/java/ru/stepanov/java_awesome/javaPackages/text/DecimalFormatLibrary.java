package ru.stepanov.java_awesome.javaPackages.text;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DecimalFormatLibrary {

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00000000", new DecimalFormatSymbols(Locale.US));

        decimalFormat.format(new BigDecimal(12));
        decimalFormat.format(null);
    }
}
