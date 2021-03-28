package edu.interview_bit.string;

public class RemoveConsecutiveCharacters {

    public static void main(String[] args) {
        String str = "aabacaad";
        int len = 2;

        System.out.println(getTrimmedString(str, len));
    }

    private static String getTrimmedString(String str, int len) {
        String result = "";

        int i=1;
        String temp = str.charAt(0)+"";

        while (i<str.length()){
            if(temp.length()<len){
                if(str.charAt(i)==str.charAt(i-1)){
                    temp += str.charAt(i);
                }else{
                    result += temp;
                    temp = str.charAt(i)+"";
                }
            }else{
                temp = str.charAt(i)+"";
            }
            i++;
        }

        if(temp.length()<len){
            result += temp;
        }

        return result;
    }
}
