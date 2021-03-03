package edu.interviewBit.binary_search;

public class WoodCuttingMadeEasy {
    
    public int solve(int[] A, int B) {
        
        int min = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<A.length; i++){
            if(max<A[i]){max=A[i];}
        }
        
        int optimalLen = -1;
        while(min<=max){
            int mid = min + (max-min)/2;
            if(isSufficient(A, mid, B)){
                optimalLen = mid;
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        
        return optimalLen;
    }
    
    private boolean isSufficient(int[] arr, int height, int requiredWood){
        int woodSum = 0;
        
        for(int i=0; i<arr.length; i++){
            woodSum += (arr[i]>=height) ? (arr[i]-height) : 0;
            if(woodSum>=requiredWood){
                return true;
            }
        }
        
        return false;
    }
    
}
