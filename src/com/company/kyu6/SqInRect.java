package com.company.kyu6;

//Reference: https://www.codewars.com/kata/55466989aeecab5aac00003e

import java.util.ArrayList;
import java.util.List;

public class SqInRect {
    public static List<Integer> sqInRect(int lng, int wdth) {
        List<Integer> sq=new ArrayList<Integer>();
        if (wdth == lng && wdth != 1){
            return null;
        }
        while(wdth >= 1 || lng >= 1){
            if(lng < wdth){
                wdth -= lng;
                sq.add(lng);
            }else if(lng > wdth){
                lng -= wdth;
                sq.add(wdth);
            }else {
                sq.add(lng);
                break;
            }
        }
        return sq;
    }
}
