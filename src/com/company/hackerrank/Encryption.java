package com.company.hackerrank;

//Reference: https://www.hackerrank.com/challenges/encryption/problem

public class Encryption {
    public static String encryption(String s){
        String noSpace = s.replaceAll("\\s+","");
        StringBuilder sb = new StringBuilder();
        int l = noSpace.length();
        int column = (int) Math.ceil(Math.sqrt(l));
        int row = (int) Math.floor(Math.sqrt(l));
        if(column * row < l)
            row++;
        char[][] chars = new char[row][column];
        System.out.println("row: " + row + " column: " + column);
        for(int i = 0; i < l; i++){
            chars[i / column][i % column] = noSpace.charAt(i);
        }
        for(int i = 0; i < column; i++){
            for(int j = 0; j < row; j++){
                if(chars[j][i] != 0){
                    sb.append(chars[j][i]);
                }
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(encryption("feedthedog"));
    }
}
