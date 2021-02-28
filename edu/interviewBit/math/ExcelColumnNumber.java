package edu.interviewBit.math;

public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int num=0;
        int len=A.length();
        for(int i=len-1; i>=0;i--){
            int ch = A.charAt(i)-64;
            // System.out.println(A.charAt(i)+":"+i+":"+(len-i-1));
            num += ch*(Math.pow(26,(len-i-1)));
        }   
        
        return num;
    }
}
