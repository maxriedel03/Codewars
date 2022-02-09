package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarMileage {
    public static void main(String[] args){
        System.out.println(isInteresting(11208, new int[]{1337, 256}));
    }

    //WORKS
    public static int isInteresting(int number, int[] awesomePhrases) {
        int result = 0;
        if(number < 98)
            result = 0;
        else {
            switch (number){
                case 98:
                    if(checkExact(100, awesomePhrases))
                        result = 1;
                    break;
                case 99:
                    if(checkExact(100, awesomePhrases) || checkExact(101, awesomePhrases))
                        result = 1;
                    break;
                case 100:
                    if (checkExact(number, awesomePhrases))
                        result = 2;
                    else if(checkExact(101, awesomePhrases) || checkExact(102, awesomePhrases))
                        result = 1;
                case 101:
                    if(checkExact(number ,awesomePhrases))
                        result = 2;
                    else if(checkExact(100, awesomePhrases) || checkExact(102, awesomePhrases)
                            || checkExact(103, awesomePhrases))
                        result = 1;
                default:
                    System.out.println(result);
                    if(checkExact(number, awesomePhrases))
                        result = 2;
                        if(checkRange(number, awesomePhrases))
                        result = 1;
                    System.out.println(result);
            }
        }
        return result;
    }

    //WORKS
    public static boolean checkExact(int number, int[] awesomePhrases){
        return (checkAwesomePhrase(number, awesomePhrases) || checkZero(number) || checkInc(number)
                || checkDec(number) || sameDigits(number) || checkPalindrome(number));
    }
    //WORKS
    public static boolean checkRange(int number, int[] awesomePhrases){
        return (checkExact(number -2, awesomePhrases) || checkExact(number -1, awesomePhrases) ||
                checkExact(number +1, awesomePhrases) ||checkExact(number +2, awesomePhrases));
    }

    public static boolean checkZero(int number){
        List<Integer> array = numberToArray(number);
        boolean result = true;
        for(int i = 1; i < array.size() && result; i++){
            if (array.get(i) != 0)
                result = false;
        }
        return result;
    }

    public static boolean checkAwesomePhrase(int number, int[] awesomePhrases){
        return Arrays.stream(awesomePhrases).filter(x -> x==number).count() >= 1;
    }
    public static boolean sameDigits(int number){
        int temp = number;
        boolean result = true;
        ArrayList<Integer> array = numberToArray(number);
        for(int i = 0; i < array.size() && result; i++){
            if(array.get(0) != array.get(i))
                result = false;
        }
        return result;
    }
    public static boolean checkInc(int number){
        ArrayList<Integer> array = numberToArray(number);
        int maxLen = 11 - array.get(0);
        if(maxLen < array.size())
            return false;

        boolean inc = true;
        int temp;
        if (array.get(0) != 0){
            for (int i= 0; i < array.size() - 1 && inc; i++){
                temp = array.get(i);
                if((temp + 1 == array.get(i+1) && temp != 9) || (temp == 9 && array.get(i +1) == 0))
                    inc = true;
                else
                    inc = false;
            }
        }else
            return false;
        return inc;
    }
    public static boolean checkDec(int number){
        ArrayList<Integer> array = numberToArray(number);
        boolean dec = true;
        int temp;
        if (array.get(0) != 0){
            for (int i= 0; i < array.size() - 1 && dec; i++){
                temp = array.get(i);
                if((temp - 1 == array.get(i+1) && temp != 0) || (temp == 1 && array.get(i +1) == 0))
                    dec = true;
                else
                    dec = false;
            }
        }else
            dec = false;
        return dec;
    }

    public static boolean checkPalindrome(int number){
        ArrayList<Integer> array = numberToArray(number);
        List<Integer> sub1;
        List<Integer> sub2;
        if(array.size()%2 == 0){
            sub1 = array.subList(0, array.size()/2 - 1);
            sub2 = array.subList(array.size()/2, array.size()-1);
        }else{
            sub1 = array.subList(0, array.size()/2 -1);
            sub2 = array.subList(array.size()/2 + 1, array.size()-1);
        }
        return sub1.equals(sub2);
    }

    //WORKS
    public static ArrayList<Integer> numberToArray(int number){
        int temp = number;
        ArrayList<Integer> array = new ArrayList<>();
        do{
            array.add(temp % 10);
            temp /= 10;
        } while  (temp > 0);
        return array;
    }
}
