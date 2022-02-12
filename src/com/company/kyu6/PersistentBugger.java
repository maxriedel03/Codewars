package com.company.kyu6;

//Reference: https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec

public class PersistentBugger {
    public static int persistence(long n) {
        int result = 0;
        while (n > 9) {
            long multi = 1;
            for (char t : String.valueOf(n).toCharArray()) {
                multi *= Long.parseLong(String.valueOf(t));
            }
            n = multi;
            result++;
        }
        return result;
    }
}
