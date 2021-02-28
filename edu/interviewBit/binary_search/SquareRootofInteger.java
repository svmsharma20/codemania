package edu.interviewBit.binary_search;

public class SquareRootofInteger {
    public int sqrt(int A) {
        if(A==1 || A==0){
            return A;
        }
        
        int low = 0;
        int high = A/2;
        
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int sqr = mid;
            
            if(sqr<(A/mid)){
                ans = mid;
                low = mid+1;
            }else if(sqr>(A/mid)){
                high = mid-1;
            }else{
                return mid;
            }
        }
        
        return ans;
    }
}
