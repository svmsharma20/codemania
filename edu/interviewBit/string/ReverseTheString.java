package edu.interviewBit.string;

public class ReverseTheString {

    public String solve(String str) {
        int i=0;
        StringBuilder result = new StringBuilder();
        while(i<str.length() && str.charAt(i)==' '){
            i++;
        }

        while(i<str.length()){
            String word = " ";
            while(i<str.length() && str.charAt(i)!=' '){
                word += str.charAt(i);
                i++;
            }
            result.insert(0, word);

            while(i<str.length() && str.charAt(i)==' '){
                i++;
            }
        }

        result.deleteCharAt(0);
        return result.toString();
    }

}
