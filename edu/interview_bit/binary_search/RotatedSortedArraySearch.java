package edu.interview_bit.binary_search;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {
    
    public static void main(String[] args) {
        Integer[] arr = {0,1,2, 3, 4, 5, 6, 7, 8};
        int B = 4;
        System.out.println(new RotatedSortedArraySearch().search(Arrays.asList(arr), B));
    }

    public int search(final List<Integer> A, int B) {

        if(A==null || A.size()==0){ return -1;}

        int low=0;
        int high=A.size()-1;

        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(A.get(low) == B){ return low;}
            if(A.get(mid) == B){ return mid;}
            if(A.get(high) == B){ return high;}

            if(A.get(low) <= A.get(mid)){
                if(A.get(low) < B && B < A.get(mid)){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(A.get(mid) < B && B < A.get(high)){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}
