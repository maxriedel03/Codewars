package com.company.kyu7;

//Reference: https://www.codewars.com/kata/54ff3102c1bad923760001f3

public class VowelCount {
    public static int getCount(String str) {
        int vowelsCount = 0;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e'
                    ||str.charAt(i) == 'i' ||str.charAt(i) == 'o'
                    ||str.charAt(i) == 'u'){
                ++vowelsCount;
            }
        }
        return vowelsCount;
    }
}
