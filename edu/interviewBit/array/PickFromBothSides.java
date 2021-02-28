package edu.interviewBit.array;

import java.util.ArrayList;

public class PickFromBothSides {
    
    public int solve(ArrayList<Integer> A, int B) {
        
        // https://www.youtube.com/watch?v=M7wV11xOM-k
        
        int n = A.size();
        int k = n-B;
        
        int totalSum = 0;
        int minSum = 0;
        
        for(int i=0; i<k; i++){
            minSum += A.get(i);
            totalSum += A.get(i);
        }
        int sum = minSum;
        for(int i=k; i<n; i++){
            sum = sum+A.get(i)-A.get(i-k);
            minSum = Math.min(minSum, sum);
            totalSum += A.get(i);
        }
        
        return totalSum-minSum;
    }

}
