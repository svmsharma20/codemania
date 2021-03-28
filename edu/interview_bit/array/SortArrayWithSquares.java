package edu.interview_bit.array;

import java.util.ArrayList;

public class SortArrayWithSquares {
    
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> sqr = new ArrayList<>();
        int left=0;
        int right=A.size()-1;
        while(left<=right){
            int leftSqr = A.get(left) * A.get(left);
            int rightSqr = A.get(right) * A.get(right);
            
            if(leftSqr >= rightSqr){
                sqr.add(0, leftSqr);
                left++;
            }else{
                sqr.add(0, rightSqr);
                right--;
            }
        }
        
        return sqr;
    }

}
