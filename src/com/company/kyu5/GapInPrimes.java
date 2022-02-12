package com.company.kyu5;

//Reference: https://www.codewars.com/kata/561e9c843a2ef5a40c0000a4

public class GapInPrimes {
    public static long[] gap(int g, long m, long n){
        long firstPrime = 0;
        long nextPrime = 0;
        for (long i = m; i <= n; i++){
            if (isPrime(i)){
                if (firstPrime == 0)
                    firstPrime = i;
                else if (nextPrime == 0)
                    nextPrime = i;
                else{
                    firstPrime = nextPrime;
                    nextPrime = i;
                }
            }
            if (firstPrime != 0 && nextPrime != 0 && nextPrime - firstPrime == g)
                return new long[]{firstPrime, nextPrime};
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
            for (int i = 3; i <= Math.ceil(Math.sqrt(number)); i += 2){
                if (number % i == 0) return false;
            }
        }
        return true;
    }
}
