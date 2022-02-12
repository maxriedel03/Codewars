package com.company.kyu7;

//Reference: https://www.codewars.com/kata/5467e4d82edf8bbf40000155

public class DescendingOrder {
    public static int sortDesc(final int num) {
        String temp = Integer.toString(num);
        int[] numArray = new int[temp.length()];
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < temp.length(); i++){
            numArray[i] = temp.charAt(i) - '0';
        }
        for (int i = 1; i < numArray.length; i++) {
            int current = numArray[i];
            int j = i - 1;
            while(j >= 0 && current > numArray[j]) {
                numArray[j+1] = numArray[j];
                j--;
            }
            numArray[j+1] = current;
        }
        for (int i : numArray) {
            s.append(i);
        }
        return Integer.parseInt(s.toString());
    }
}
