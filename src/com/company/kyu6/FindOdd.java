package com.company.kyu6;

//Reference: https://www.codewars.com/kata/54da5a58ea159efa38000836

public class FindOdd {
    public static int findIt(int[] a){
        int odd = 0;
        for(int num : a)
            odd ^= num;
        return odd;
    }
}
