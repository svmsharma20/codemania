package edu.interviewBit.array;

import java.util.ArrayList;

public class FindPermutation {
    
    public ArrayList<Integer> findPerm(final String str, int n) {
        
        int low=1;
        int high=n;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i)=='I'){
                list.add(0, high);
                high--;
            }else{
                list.add(0, low);
                low++;
            }
        }
        
        list.add(0, low);
        
        return list;
    }

}
