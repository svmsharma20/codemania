package edu.interviewBit.string;

public class ImplementStrStr {
    
    public int strStr(final String A, final String B) {
        if(A==null || A.length()==0 || B==null || B.length()==0){
            return -1;
        }
      
       int i=0;
       int j=0;
        
        while(i<B.length() && j<A.length()){
            if(B.charAt(i)==A.charAt(j)){
                i++;
                j++;
            }else{
                // Go back (i-1) steps to start again
                j=j-i+1;
                i=0;
            }
        }
        
        if(i==B.length()){
            return (j-B.length());
        }
        
        return -1;
    }

}
