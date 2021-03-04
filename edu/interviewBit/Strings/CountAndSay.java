package edu.interviewBit.Strings;

// https://www.interviewbit.com/problems/count-and-say/

public class CountAndSay {
    
    public String countAndSay(int n) {
        
        int i=1;
        String str = "1";
        
        while(i<n){
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
                count=0;
                ch=s.charAt(i);
            }
        }
        
        nextString += count+""+ch;
        
        return nextString;
    }

}
