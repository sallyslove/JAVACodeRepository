package com.lynn.java.addressbook.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static boolean isNum(String string) {
        boolean result = false;
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(string);
        if (isNum.matches()) {
            result = true;
        }
        return result;
    }
}
