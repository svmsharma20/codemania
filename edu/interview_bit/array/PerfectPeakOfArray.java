package edu.interview_bit.array;

import java.util.ArrayList;

public class PerfectPeakOfArray {
    
    public int perfectPeak(ArrayList<Integer> A) {
        
        if(A==null || A.size()<3){
            return 0;
        }
        
        int size = A.size();
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        
        prefix[0] = A.get(0);
        suffix[size-1] = A.get(size-1);
        
        for(int i=1; i<size; i++){
            prefix[i] = Math.max(prefix[i-1], A.get(i-1));
        }
        
        for(int i=size-2; i>=0; i--){
            suffix[i] = Math.min(suffix[i+1], A.get(i+1));
        }
        
        for(int i=1; i<size-1; i++){
            if(A.get(i) > prefix[i] && A.get(i)<suffix[i]){
                return 1;
            }
        }
        
        return 0;
        
    }

}
