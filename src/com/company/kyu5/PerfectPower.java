package com.company.kyu5;

//Reference: https://www.codewars.com/kata/54d4c8b08776e4ad92000835

public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        for(int m = 2; m <= Math.sqrt(n); m++){
            int k = (int)Math.round((Math.log10(n))/Math.log10(m));
            if(Math.pow(m, k) == n){
                return new int[]{m,k};
            }
        }
        return null;
    }
}
