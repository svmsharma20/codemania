package edu.interview_bit.array;

import java.util.ArrayList;

public class MaximumUnsortedSubarray {
    
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        
        int n=A.size();
        
        int start=-1;
        int end=-1;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<n-1; i++){
            if(A.get(i)>A.get(i+1)){
                start = i;
                break;
            }
        }
        
        for(int i=n-1; i>0; i--){
            if(A.get(i)<A.get(i-1)){
                end = i;
                break;
            }
        }
        
        if(start==-1){
            result.add(-1);
            return result;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=start; i<=end; i++){
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }
        
        for(int i=0; i<start; i++){
            if(A.get(i)>min){
                start=i;
                break;
            }
        }
        
        
        
        for(int i=n-1; i>end; i--){
            if(A.get(i)<max){
                end=i;
                break;
            }
        }
        
        result.add(start);
        result.add(end);
        
        return result;
    }

}
