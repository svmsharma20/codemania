package edu.interviewBit.string;

public class ZigzagString {

    public static void main(String[] args) {
        String inputStr = "PAYPALISHIRING";
        int rows = 3;
        System.out.println(convertInZigzagPatter(inputStr, rows));
    }

    private static String convertInZigzagPatter(String inputStr, int rows) {

        if(rows==1){
            return inputStr;
        }

        String[] zigzagPattern = new String[rows];

        for (int i = 0; i < zigzagPattern.length; i++) {
            zigzagPattern[i] = new String();
        }

        boolean isDecending = true;
        int rowOfZigzag = 0;

        for (int i = 0; i < inputStr.length(); i++) {
            zigzagPattern[rowOfZigzag] += inputStr.charAt(i);

            if (isDecending){
                rowOfZigzag++;
            }else{
                rowOfZigzag--;
            }

            if(rowOfZigzag==zigzagPattern.length){
                isDecending = false;
                rowOfZigzag--;
                rowOfZigzag--;
            }

            if(rowOfZigzag==-1){
                isDecending = true;
                rowOfZigzag++;
                rowOfZigzag++;
            }
        }

        StringBuilder result = new StringBuilder();

        for (String row: zigzagPattern) {
            result.append(row );
        }

        return result.toString();
    }
}
