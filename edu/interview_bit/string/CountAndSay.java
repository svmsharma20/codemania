package edu.interview_bit.string;

// https://www.interviewbit.com/problems/count-and-say/

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSayOptimized(5));
    }

    public String countAndSay(int n) {

        int i = 1;
        String str = "1";

        while (i < n) {
            str = getNext(str);
            i++;
        }
        
        return str;
    }
    
    private String getNext(String s){
        int i=0;
        String nextString = "";
        char ch = s.charAt(i);
        int count=0;
        
        while(i<s.length()){
            if(s.charAt(i)==ch){
                count++;
                i++;
            }else{
                nextString += count+""+ch;
                count = 0;
                ch = s.charAt(i);
            }
        }

        nextString += count + "" + ch;

        return nextString;
    }

    public static String countAndSayOptimized(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSayOptimized(n - 1) + "*";
        int count = 1;
        String res = "";
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                res += (count + "" + str.charAt(i));
                count = 1;
            }
        }
        return res;
    }
}
