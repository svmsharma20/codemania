package edu.interview_bit.array;

import java.util.TreeSet;
import java.util.ArrayList;

public class MaximumSumTriplet {
    
    public int solve(ArrayList<Integer> A) {
        if(A==null || A.size()<3){
            return 0;
        }
        
        int[] rightSuffixArray = new int[A.size()];
        int max = Integer.MIN_VALUE;
        
        for(int i=A.size()-1; i>=0; i--){
            max = Math.max(max, A.get(i));
            rightSuffixArray[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(A.get(0));
        
        for(int j=1; j<A.size()-1; j++){
            
            Integer maxLowestToLeft = set.lower(A.get(j));
            set.add(A.get(j));
            // System.out.println()
            if(maxLowestToLeft == null || rightSuffixArray[j+1]<=A.get(j)){
                continue;
            }
            
            max = Math.max(max, A.get(j)+rightSuffixArray[j+1]+maxLowestToLeft);        
        }
        
        return max;
    }

}
