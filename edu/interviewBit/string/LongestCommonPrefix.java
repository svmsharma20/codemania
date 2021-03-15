package edu.interviewBit.string;

// https://www.interviewbit.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    
    public String longestCommonPrefix(String[] A) {
        
        if(A==null || A.length==0){
            return "";
        }
        
        String commonString = A[0];
        
        for(int i=1; i<A.length; i++){
            commonString = getCommon(commonString, A[i]);
        }
        
        return commonString;
    }
    
    private String getCommon(String s1, String s2){
        int i=0;
        
        if(s2.length() < s1.length()){
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }
        
        while(i<s1.length()){
            if(s1.charAt(i)!=s2.charAt(i)){
                return s1.substring(0,i);
            }
            
            i++;
        }
        
        return s1;
    }
    
}
