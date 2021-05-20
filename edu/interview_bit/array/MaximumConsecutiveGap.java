package edu.interview_bit.array;

import java.util.List;
import java.util.HashSet;

public class MaximumConsecutiveGap {
    // https://www.youtube.com/watch?v=VT-6zwGKYwA
    
    public int maximumGap(final List<Integer> A) {
        if(A==null || A.size()<2){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        HashSet<Integer> set = new HashSet<>(A);
        
        int size = set.size();
        
        for(Integer n : A){
            max = (n>max)? n : max;
            min = (n<min)? n : min;
        }
        
        int minGap = (int)Math.ceil((max-min)/(size-1.0));
        
        if(minGap==0){
            return 0;
        }
        
        // System.out.println(size);
        
        int[][] bucket = new int[size-1][2];
        
        for(int i=0; i<size-1; i++){
            bucket[i][0] = Integer.MAX_VALUE;
            bucket[i][1] = Integer.MIN_VALUE;
        }

        for(Integer n : set){
            
            if(n==min || n==max){
                continue;
            }
            
            int interval = (n-min)/minGap;
            bucket[interval][0] = Math.min(n, bucket[interval][0]);
            bucket[interval][1] = Math.max(n, bucket[interval][1]);
        }
        
        int maxGap = 0;
        int prev = min;
        for(int i=0; i<bucket.length; i++){
            if(bucket[i][0] != Integer.MAX_VALUE){
                maxGap = Math.max(maxGap, bucket[i][0]-prev);
            }
            
            if(bucket[i][1] != Integer.MIN_VALUE){
                prev = bucket[i][1];
            }
            
        }
        
        return Math.max(maxGap, max-prev);
    }
}
