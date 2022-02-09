package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {


    public static String formatDuration(int seconds){
        if(seconds == 0)
            return "now";
        String[] type = {"year", "day", "hour", "minute", "second"};
        int year = seconds/(60 * 60 * 24 * 365);
        int day = (seconds%(60 * 60 * 24 * 365))/(60 * 60 * 24);
        int hours = ((seconds%(60*60*24*365))%(60*60*24))/(60*60);
        int minutes =(((seconds%(60*60*24*365))%(60*60*24))%(60*60))/60;
        int sec = (((seconds%(60*60*24*365))%(60*60*24))%(60*60))%60;
        StringBuilder sb = new StringBuilder();
        int[] nums = {year, day, hours, minutes, sec};
        ArrayList<String> ls = new ArrayList<>();
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            if (num == 1)
                ls.add(num + " " + type[i]);
            else if (num > 1)
                ls.add(num + " " + type[i] + "s");
        }
        for(int i = 0, lsLength = ls.size(); i < lsLength; i++){
            if(ls.size() - 2 == i){
                sb.append(ls.get(i) + " and " + ls.get(i+1));
                break;
            }
            if(ls.size() - 1 != i)
                sb.append(ls.get(i) + ", ");
            else
                sb.append(ls.get(i));
        }
        return sb.toString();
    }


    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals[0] == null)
            return 0;
        int[][] fixedInterval = fixInterval(intervals);
        int[] dif = new int[fixedInterval.length];
        for (int i = 0, arrLength = fixedInterval.length; i < arrLength; i++) {
            dif[i] = fixedInterval[i][1] - fixedInterval[i][0];
        }
        int sum = 0;
        for (int num : dif)
            sum += num;
        return sum;
    }
    public static int[][] fixInterval(int[][] intervals){
        int count = 0;
        int intervalLen = intervals.length;
        ArrayList<int[]> ls = new ArrayList<>();
        int i = 0;
        while (i < intervalLen - 1){
            if(intervals[i][1] < intervals[i+1][0])
                ls.add(intervals[i]);
            else if(intervals[i][1] == intervals[i+1][0]){
                ls.add(new int[]{intervals[i][0], intervals[i+1][1]});
                i++;
                count++;
            }
            else{
                ls.add(new int[]{intervals[i][0], intervals[i+1][1]});
                i++;
                count++;
            }
            i++;
        }
        if(count == 0)
            return ls.toArray(new int[ls.size()][]);
        else
            return  fixInterval(ls.toArray(new int[ls.size()][]));
    }

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
    public static void main(String[] args){
        final String ADD = "+";
        final String SUB = "-";
        final String MULT = "*";
        final String DIV = "/";

        int num1;
        int num2;
        int result;

        String operation;

        Scanner sc = new Scanner(System.in);

        num1 = sc.nextInt();
        num2 = sc.nextInt();

        System.out.println("________");
        operation = sc.next();
        System.out.println("________");
        result = 0;

        if(num1 > 0 && num2 > 0 && num1 <= 1000 && num2 <= 1000 && (operation.equals(ADD) || operation.equals(SUB) || operation.equals(MULT) || operation.equals(DIV))){
            switch(operation){
                case ADD:
                    result = num1 + num2;
                    break;
                case SUB:
                    result = num1 - num2;
                    break;
                case MULT:
                    result = num1 * num2;
                    break;
                case DIV:
                    result = num1 / num2;
                    break;
            }
            System.out.println(result);
        }else{
            System.out.println("Eingabefehler");
        }
        sc.close();
    }



































































    public static String stripComments(String text, String[] commentSymbols) {
        if (text.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] strings = text.split("\n");
        for (String s : strings) {
            StringBuilder sbTemp = new StringBuilder();
            int commentIndex = s.length();
            if (commentIndex != 0) {
                for (String commentSymbol : commentSymbols) {
                    if (s.contains(commentSymbol))
                        commentIndex = s.indexOf(commentSymbol);
                }
                sbTemp.append(s, 0, commentIndex);
            }
            while (sbTemp.length() != 0 && sbTemp.charAt(sbTemp.length() - 1) == ' ') {
                sbTemp.setLength(sbTemp.length() - 1);
            }
            sbTemp.append("\n");
            sb.append(sbTemp);
        }
        if (sb.length() != 0) {
            sb.setLength(sb.length() - 1);
        }
        return new String(sb);
    }


    public static long nextSmaller(long n){
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);
        int lastDigit = Integer.parseInt(String.valueOf(s.charAt(s.length() -1)));
        for(int i = s.length() - 2; i > -1; i--){
            int tempDigit = Integer.parseInt(String.valueOf(s.charAt(i)));
            if(tempDigit > lastDigit){
                sb.append(s, 0, i-1);
                sb.append(lastDigit);
                for(int j = i + 1;  j < sb.length() - 2; j++){
                    sb.append(s.charAt(j));
                }
                sb.append(tempDigit);
            }
        }
        return Long.parseLong(sb.toString());
    }

}
