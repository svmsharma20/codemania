package edu.interviewBit.array;

import java.util.List;

public class MaxSumContiguousSubarray {
    public int maxSubArray(final List<Integer> A) {
        int maxSum = A.get(0);
        int sum = A.get(0);
        
        for(int i=1; i< A.size(); i++){
            sum = sum + A.get(i);
            if(maxSum<sum){
                maxSum = Math.max(maxSum, Math.max(sum, A.get(i)));
            }
            if(sum<0){
                sum=0;
            }
        }
        
        return maxSum;
    }
}
