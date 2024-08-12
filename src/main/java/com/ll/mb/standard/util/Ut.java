package com.ll.mb.standard.util;

public class Ut {
    public static class str {
        
        public static String lcfirst(String str) {
            if (str == null || str.isEmpty()) {
                return str;
            }
            return Character.toLowerCase(str.charAt(0)) + str.substring(1);
        }
    }
}
