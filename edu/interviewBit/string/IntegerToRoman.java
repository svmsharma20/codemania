package edu.interviewBit.string;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    private static boolean isInitialize = false;

    private static Map<Integer, String> ones = new HashMap<>();
    private static Map<Integer, String> tens = new HashMap<>();
    private static Map<Integer, String> hundredth = new HashMap<>();
    private static Map<Integer, String> thousands = new HashMap<>();

    public static void main(String[] args) {
        int numeral = 3947;
        System.out.println(calculateRomanEquvivalent(3947));
    }

    private static String calculateRomanEquvivalent(int numeral) {
        initializeUnitMaps();

        return (thousands.get(numeral/1000) + hundredth.get((numeral%1000)/100) + tens.get((numeral%100)/10) + ones.get(numeral%10));
    }

    private static void initializeUnitMaps() {

        if(!isInitialize){

            ones.put(0, "");
            ones.put(1, "I");
            ones.put(2, "II");
            ones.put(3, "III");
            ones.put(4, "IV");
            ones.put(5, "V");
            ones.put(6, "VI");
            ones.put(7, "VII");
            ones.put(8, "VIII");
            ones.put(9, "IX");

            tens.put(0, "");
            tens.put(1, "X");
            tens.put(2, "XX");
            tens.put(3, "XXX");
            tens.put(4, "XL");
            tens.put(5, "L");
            tens.put(6, "LX");
            tens.put(7, "LXX");
            tens.put(8, "LXXX");
            tens.put(9, "XC");

            hundredth.put(0, "");
            hundredth.put(1, "C");
            hundredth.put(2, "CC");
            hundredth.put(3, "CCC");
            hundredth.put(4, "CD");
            hundredth.put(5, "D");
            hundredth.put(6, "DC");
            hundredth.put(7, "DCC");
            hundredth.put(8, "DCCC");
            hundredth.put(9, "CM");

            thousands.put(0, "");
            thousands.put(1, "M");
            thousands.put(2, "MM");
            thousands.put(3, "MMM");

            isInitialize = true;
        }
    }

}
