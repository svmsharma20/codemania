package edu.interviewBit.binary_search;

public class SearchInBitonicArray {
    
    public int solve(int[] A, int B) {
        int low=0;
        int high=A.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(A[mid]==B){
                return mid;
            }
            
           if(mid+1<A.length){
               if(A[mid]>A[mid+1]){
                   if(A[mid]>B && B>=A[high]){
                       low = mid+1;
                   }else{
                       high = mid-1;
                   }
               }else{
                   if(A[low]<=B && B<A[mid]){
                       high = mid-1;
                   }else{
                       low=mid+1;
                   }
               }
           }else{
               return -1;
           }
        }
        
        return -1;
    }
}
