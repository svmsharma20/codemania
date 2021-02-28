package edu.interviewBit.math;

public class StepByStep {
    
    public int solve(int A) {
        int count=0;
        int sum = 0;
        A = Math.abs(A);
        while(true){
            count++;
            if(sum<A){
                sum += count;
            }else if((sum-A)%2==0){
                return count-1;
            }else{
                sum += count;
            }
        }
    }
    
}
