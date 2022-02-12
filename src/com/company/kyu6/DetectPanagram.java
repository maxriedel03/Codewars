package com.company.kyu6;

//Reference: https://www.codewars.com/kata/545cedaa9943f7fe7b000048

public class DetectPanagram {
    public boolean check(String sentence){
        String sentence1 = sentence.toLowerCase();
        int temp = 0;
        for(char j = 97; j < 123; j++){
            for (int i= 0; i < sentence1.length(); i++){
                if (sentence1.charAt(i) == j){
                    temp +=1;
                    break;
                }
            }
            if((int) j - 96 != temp){
                return false;
            }
        }
        return true;
    }
}
