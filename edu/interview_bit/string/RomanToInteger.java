package edu.interview_bit.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // Higher the rank higher the value
    private static Map<Character, Integer> rank = new HashMap<>();
    private static Map<Character, Integer> values = new HashMap<>();

    public static void main(String[] args) {
        String roman = "MMMCMXLIV";

        System.out.println(calculateInteger(roman));
    }

    private static int calculateInteger(String roman) {

        initializeRankAndValues();

        int result=0;
        for (int i = 0; i < roman.length(); i++) {
            if(i<roman.length()-1 && rank.get(roman.charAt(i))<rank.get(roman.charAt(i+1))){
                result -= values.get(roman.charAt(i));
            }else{
                result += values.get(roman.charAt(i));
            }
        }

        return result;
    }

    private static void initializeRankAndValues() {
        rank.put('M',7);
        rank.put('D',6);
        rank.put('C',5);
        rank.put('L',4);
        rank.put('X',3);
        rank.put('V',2);
        rank.put('I',1);

        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }


}
