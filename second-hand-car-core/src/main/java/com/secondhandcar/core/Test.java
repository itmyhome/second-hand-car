package com.secondhandcar.core;

/**
 * Created by xiet on 2017/10/12.
 */
public class Test {
    public static void main(String[] args) {
        String str = "我...我...要..要.吃...吃...饭";
        String regex = "\\.+";
        String newStr = "";
        str=test(str, regex, newStr);
        regex = "(.)\\1+";
        newStr = "$1";
        test(str, regex, newStr);

    }

    public static String test(String str, String regex, String newStr) {
        String str2 = str.replaceAll(regex, newStr);
        System.out.println(str2);
        return str2;
    }
}
