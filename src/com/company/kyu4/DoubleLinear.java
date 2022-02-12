package com.company.kyu4;

//Reference: https://www.codewars.com/kata/5672682212c8ecf83e000050

import java.util.ArrayList;

public class DoubleLinear {
    public static int dblLinear (int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int smallCount = 0;
        int bigCount = 0;
        while(list.size() <= n){
            int x = 2*list.get(smallCount) + 1;
            int y = 3*list.get(bigCount) + 1;
            if(x < y){
                list.add(x);
                ++smallCount;
            }else if(x > y){
                list.add(y);
                ++bigCount;
            }else{
                list.add(x);
                ++smallCount;
                ++bigCount;
            }
        }
        return list.get(n);
    }
}
