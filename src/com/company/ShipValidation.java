package com.company;

import java.util.*;

public class ShipValidation{

    static List<Integer> fieldsChecked = new ArrayList<>(){};
    static Map<Integer, Integer> shipCount;

    public static boolean fieldValidator(int[][] field){
        shipCount = new HashMap<>();
        shipCount.put(1, 0);
        shipCount.put(2, 0);
        shipCount.put(3,0);
        shipCount.put(4,0);
        fieldsChecked.clear();
        int linesChecked = 0;
        boolean tempValidBoat = true;
        int i;
        while(linesChecked < 10 && tempValidBoat){
            i = linesChecked;
            int j = 0;
            while (j < 10 && tempValidBoat){
                if(!fieldsChecked.contains(Integer.parseInt(String.valueOf(i) + String.valueOf(j)))){
                    if(field[i][j] == 1){
                        tempValidBoat = checkForValidBoat(field, i, j);
                    }
                }
                j++;
            }
            linesChecked++;
        }
        System.out.println(fieldsChecked.size());
        return checkBoatCount();
    }

    public static boolean checkBoatCount(){
        return shipCount.get(4) == 1 && shipCount.get(3) == 2 && shipCount.get(2) == 3 && shipCount.get(1) == 4;
    }

    public static boolean checkForValidBoat(int[][] field, int currentLineIndex, int currentRowIndex){
        boolean validBoat = false;
        boolean tempCheck;
        int boatLen = 1;
        int i = currentLineIndex;
        int j = currentRowIndex;
        if(j+1 != 10 && field[i][j + 1] == 1){
            tempCheck = checkValidSurrounding(field, i, j, false, false, false, true);
            fieldsChecked.add(Integer.parseInt(String.valueOf(i) + String.valueOf(j)));
            while(j+1 != 10 && field[i][j + 1] == 1 && tempCheck){
                j++;
                if(j+1 != 10 && field[i][j + 1] == 1 && boatLen + 1 < 5)
                    tempCheck = checkValidSurrounding(field, i, j, false, false, true, true);
                else
                    tempCheck = checkValidSurrounding(field, i, j, false, false, true, false);
                fieldsChecked.add(Integer.parseInt(String.valueOf(i) + String.valueOf(j)));
                boatLen++;
            }
            if(tempCheck)
                validBoat = true;
        }else if(i+1 != 10 && field[i +1][j] == 1){
            tempCheck = checkValidSurrounding(field, i, j, false, true, false, false);
            fieldsChecked.add(Integer.parseInt(String.valueOf(i) + String.valueOf(j)));
            while(i+1 != 10 && field[i + 1][j] == 1 && tempCheck){
                i++;
                if(i+1 != 10 && field[i +1][j] == 1 && boatLen + 1 < 5)
                    tempCheck = checkValidSurrounding(field, i, j, true, true, false, false);
                else
                    tempCheck = checkValidSurrounding(field, i, j, true, false, false, false);
                fieldsChecked.add(Integer.parseInt(String.valueOf(i) + String.valueOf(j)));
                boatLen++;
            }
            if(tempCheck)
                validBoat = true;
        }else{
            validBoat = checkValidSurrounding(field,i, j, false, false, false ,false);
            fieldsChecked.add(Integer.parseInt(String.valueOf(i) + String.valueOf(j)));
        }
        int count = shipCount.containsKey(boatLen) ? shipCount.get(boatLen) : 0;
        shipCount.put(boatLen, count + 1);

        return validBoat;
    }

    public static boolean checkValidSurrounding(int[][] field, int currentLineIndex, int currentRowIndex,
                                                boolean ignoreTop, boolean ignoreBottom, boolean ignoreLeft, boolean ignoreRight){
        boolean topLeft = currentLineIndex != 0 && currentRowIndex != 0;
        boolean topRight = currentLineIndex != 0 && currentRowIndex != 9;
        boolean bottomLeft = currentLineIndex != 9 && currentRowIndex != 0;
        boolean bottomRight = currentLineIndex != 9 && currentRowIndex != 9;
        boolean validSurrounding = true;
        if(currentLineIndex != 0 && !ignoreTop && validSurrounding)
            validSurrounding = field[currentLineIndex - 1][currentRowIndex] == 0;
        if(currentLineIndex != 9 && !ignoreBottom && validSurrounding)
            validSurrounding = field[currentLineIndex + 1][currentRowIndex] == 0;
        if(currentRowIndex != 0 && !ignoreLeft && validSurrounding)
            validSurrounding = field[currentLineIndex][currentRowIndex - 1] == 0;
        if(currentRowIndex != 9 && !ignoreRight && validSurrounding)
            validSurrounding = field[currentLineIndex][currentRowIndex + 1] == 0;
        if(topLeft && validSurrounding)
            validSurrounding = field[currentLineIndex - 1][currentRowIndex - 1] == 0;
        if(topRight && validSurrounding)
            validSurrounding = field[currentLineIndex - 1][currentRowIndex + 1] == 0;
        if(bottomLeft && validSurrounding)
            validSurrounding = field[currentLineIndex + 1][currentRowIndex - 1] == 0;
        if(bottomRight && validSurrounding)
            validSurrounding = field[currentLineIndex + 1][currentRowIndex + 1] == 0;
        return validSurrounding;
    }

}
