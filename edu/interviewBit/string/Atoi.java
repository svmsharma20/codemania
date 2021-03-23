package edu.interviewBit.string;

public class Atoi {

    public int atoi(final String str) {
        int i=0;
        while(i<str.length() && str.charAt(i)==' '){
            i++;
        }

        if(i==str.length()){
            return 0;
        }

        boolean isNegative = false;

        if(str.charAt(i)=='-'){
            isNegative = true;
            i++;
        }

        int result=0;

        while(i<str.length()){
            char ch = str.charAt(i);

            if(Character.isDigit(ch)){
                int newResult = result*10+Integer.parseInt(ch+"");
                if(result==(newResult/10)){
                    result =newResult;
                }else if(isNegative){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }else if(isNegative){
                return (result*-1);
            }else return result;
            i++;
        }

        return (isNegative) ? (result*-1) : result;
    }

}
