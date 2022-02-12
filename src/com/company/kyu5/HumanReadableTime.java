package com.company.kyu5;

//Reference: https://www.codewars.com/kata/52685f7382004e774f0001f7

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        String time = "";
        int hours = seconds / (60 * 60);
        int minutes = (seconds - (hours * 60 * 60))/60;
        int sec = (seconds - (hours * 60 * 60) - (minutes * 60));
        if (hours < 10){
            time += "0" + hours + ":";
            if(minutes < 10){
                time += "0" + minutes + ":";
                if(sec < 10){
                    time += "0" + sec;
                }else{
                    time += sec;
                }
            }else{
                time += minutes + ":";
                if(sec < 10){
                    time += "0" + sec;
                }else{
                    time += sec;
                }
            }
        }else{
            time += hours + ":";
            if(minutes < 10){
                time += "0" + minutes + ":";
                if(sec < 10){
                    time += "0" + sec;
                }else{
                    time += sec;
                }
            }else{
                time += minutes + ":";
                if(sec < 10){
                    time += "0" + sec;
                }else{
                    time += sec;
                }
            }
        }
        return time;
    }
}
