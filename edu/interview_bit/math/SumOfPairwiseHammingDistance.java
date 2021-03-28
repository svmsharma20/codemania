package edu.interview_bit.math;

import java.util.List;

public class SumOfPairwiseHammingDistance {
    
    // https://www.youtube.com/watch?v=EaE0fW3Xlx8
    public int hammingDistance(final List<Integer> A) {
        
        long count = 0;
        long n = A.size();
        long ans = 0;
        
        /*
        *   Lets see digits at each place one by one 
        *   of all the numbers.
        *   Count how many have 1's at the jth place in their bitwise representation 
         */
         int flag = 1;
        for(int j=0; j<31; j++){
            count=0;
            for(int i=0; i<n; i++){
                if((A.get(i)&flag)!=0){
                    count++;   
                }
            }
            flag <<= 1;
            /* 
            * Why modulo 1000000007 : 
            * https://codeaccepted.wordpress.com/2014/02/15/output-the-answer-modulo-109-7/
            */
            ans = (ans+(count*(n-count)*2))%1000000007;
            
        }
        
        return (int)ans;
        
    }
}
