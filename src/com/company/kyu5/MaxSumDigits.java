package com.company.kyu5;

import java.util.Arrays;
import java.util.stream.LongStream;

//Reference: https://www.codewars.com/kata/55f5efd21ad2b48895000040

public class MaxSumDigits {
    public static long[] maxSumDig(long nmax, int maxsm) {
        long[] digits = LongStream.range(1000, nmax + 1)
                .filter(x -> filterAboveMaxSum(x, maxsm))
                .toArray();
        long amount = digits.length;
        double meanOfNums = LongStream.of(digits).sum()/digits.length;
        long closest = LongStream.of(digits)
                .reduce((result, current) ->
                        Math.abs(meanOfNums - current) <= Math.abs(meanOfNums - result) ? current : result)
                .getAsLong();
        long sum = Arrays.stream(digits).sum();
        return new long[]{amount, closest, sum};
    }
    public static boolean filterAboveMaxSum(long num, int maxsm){
        if(String.valueOf(num).length() <= 4 && String.valueOf(num).chars().map(Character::getNumericValue).sum() <= maxsm)
            return true;
        int[] digits = Long.toString(num)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
        int i = 0;
        while (i + 3 < digits.length){
            if(digits[i]+digits[i+1]+digits[i+2]+digits[i+3] > maxsm)
                return false;
            i++;
        }
        return true;
    }
}
