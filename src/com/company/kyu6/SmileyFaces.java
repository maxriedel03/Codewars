package com.company.kyu6;

//Reference: https://www.codewars.com/kata/583203e6eb35d7980400002a

import java.util.List;

public class SmileyFaces {
    public static int countSmileys(List<String> arr) {
        int count = 0;
        for (String s : arr){
            final boolean isPunkt = s.charAt(0) == ':' || s.charAt(0) == ';';
            if (s.length() == 2){
                if (isPunkt && (s.charAt(1) == 'D' || s.charAt(1) == ')')){
                    count++;
                }
            }
            if (s.length() == 3){
                if (isPunkt && (s.charAt(1) == '-' || s.charAt(1) == '~') && (s.charAt(2) == 'D' || s.charAt(2) == ')')){
                    count++;
                }
            }
        }
        return count;
    }
}
