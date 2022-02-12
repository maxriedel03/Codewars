package com.company.kyu6;

//Reference: https://www.codewars.com/kata/5679aa472b8f57fb8c000047

public class EqualSidesOfArray {
    public static int findEvenIndex(int[] arr) {
        for (int rangeOne = 0; rangeOne < arr.length; rangeOne++){
            int sumOne = 0;
            int sumTwo = 0;
            for (int i = 0; i < rangeOne; i++){
                sumOne += arr[i];
            }
            for(int j = rangeOne + 1; j<arr.length; j++){
                sumTwo += arr[j];
            }
            if(sumOne == sumTwo){
                return rangeOne;
            }
        }
        return -1;
    }
}
