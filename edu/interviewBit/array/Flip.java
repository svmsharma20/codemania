package edu.interviewBit.array;

import java.util.ArrayList;

public class Flip {
    // https://www.youtube.com/watch?v=cLVpE5q_-DE
    
    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(A==null || A.indexOf("0") == -1){
            return ans;
        }
        
        int count=0;
        int maxCount = Integer.MIN_VALUE;
        
        int l=0;
        int r=0;
        
        int lTemp=0;
        
        for(int i=0; i<A.length(); i++){
            
            // max count of after flipping = max(max count of '0' - min count of '1'
            
            if(A.charAt(i)=='0'){
                count++;
            }else{
                count--;
            }
            
            if(count>maxCount){
                maxCount=count;
                l=lTemp;
                r=i;
            }
            
            if(count<0){
                count=0;
                lTemp = i+1;
            }
            
        }
        
        ans.add(l+1);
        ans.add(r+1);
        
        return ans;
        
    }
}
