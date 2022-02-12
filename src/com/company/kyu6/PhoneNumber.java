package com.company.kyu6;

//Reference: https://www.codewars.com/kata/525f50e3b73515a6db000b83

public class PhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder phone = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            if (i == 0){
                phone.append("(");
            }else if (i == 3){
                phone.append(") ");
            }else if (i == 6){
                phone.append("-");
            }
            phone.append(numbers[i]);
        }
        return phone.toString();
    }
}
