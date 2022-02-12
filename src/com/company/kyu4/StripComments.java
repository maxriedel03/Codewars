package com.company.kyu4;

//Reference: https://www.codewars.com/kata/51c8e37cee245da6b40000bd

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        if (text.isEmpty())
            return null;
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
            while (sbTemp.length() != 0 && sbTemp.charAt(sbTemp.length() - 1) == ' ')
                sbTemp.setLength(sbTemp.length() - 1);
            sbTemp.append("\n");
            sb.append(sbTemp);
        }
        if (sb.length() != 0)
            sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
