package com.company.kyu6;

//Reference: https://www.codewars.com/kata/517abf86da9663f1d2000003

public class CamelCase {
    static String toCamelCase(String s){
        StringBuilder sb = new StringBuilder();
        boolean isIndicator = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))){
                char tempChar = s.charAt(i);
                if (isIndicator){
                    tempChar = Character.toUpperCase(tempChar);
                }
                sb.append(tempChar);
                isIndicator = false;
            } else {
                isIndicator = true;
            }
        }
        return sb.toString();
    }
}
