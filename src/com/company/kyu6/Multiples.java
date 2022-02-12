package com.company.kyu6;

//Reference: https://www.codewars.com/kata/514b92a657cdc65150000006

public class Multiples {
    public int solution(int number) {
        int result = 0;
        if(number < 0){
            return result;
        }
        for (int i = 3; i < number; i+=3){
            result += i;
        }
        for (int i = 5; i < number; i +=5){
            if (i%3 != 0){
                result +=i;
            }
        }
        return result;
    }
}
