package com.company.kyu6;

//Reference: https://www.codewars.com/kata/5526fc09a1bbd946250002dc

import java.util.Arrays;

public class FindOutlier {
    static int find(int[] arr){
        int[] odds = Arrays.stream(arr).filter(x -> x%2 != 0).toArray();
        int[] evens = Arrays.stream(arr).filter(x -> x%2 == 0).toArray();
        return evens.length < odds.length ? evens[0]:odds[0];
    }
}
