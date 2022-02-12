package com.company.kyu6;

//Reference: https://www.codewars.com/kata/5613d06cee1e7da6d5000055

public class StepsInPrimes {
    public static long[] step(int g, long m, long n){
        for (long i = m; i <= n; i++) {
            if (isPrime(i)){
                if (isPrime(i + g) && (i + g) <= n){
                    return new long[]{ i, i + g};
                }
            }
        }
        return null;
    }
    public static boolean isPrime(long number) {
        if (number == 1)
            return false;
        else if (number == 2)
            return true;
        else if (number % 2 == 0)
            return false;
        else {
            for (int i = 3; i <= Math.sqrt(number); i += 2){
                if (number % i == 0) return false;
            }
        }
        return true;
    }
}
