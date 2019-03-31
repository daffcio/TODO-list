package com.company.util;

public class Utils {

    public static boolean isAlpha(String string) {
        return string.matches("[a-zA-Z]+"); // jakiś znak, co najmniej jeden
    }

    public static boolean isAlphanumeric(String string) {
        return string.matches("[a-zA-Z0-9]+"); // jakiś znak co najmniej jeden
    }
}
