package edu.interview_bit.binary_search;

public class SearchForARange {
    
    public int[] searchRange(final int[] A, int B) {
        int start=-1;
        int end=-1;
        
        int left=0;
        int right=A.length-1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(A[mid]==B){
                start=mid;
                right=mid-1;
            }else if(A[mid]<B){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        
        left=0;
        right=A.length-1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(A[mid]==B){
                end=mid;
                left=mid+1;
            }else if(A[mid]<B){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        
        int result[] = {start, end};
        
        return result;
    }
    
}
