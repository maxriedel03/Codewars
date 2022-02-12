package com.company.kyu4;

//Reference: https://www.codewars.com/kata/52742f58faf5485cae000b9a

import java.util.ArrayList;

public class TimeFormatter {
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
}
