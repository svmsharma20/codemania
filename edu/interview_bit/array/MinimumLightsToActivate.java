package edu.interview_bit.array;

import java.util.ArrayList;

public class MinimumLightsToActivate {
    
    public int solve(ArrayList<Integer> A, int B) {
        
        if(A==null || A.size()==0){
            return 0;
        }
        
        int size = A.size();
        int count = 0;
        int current=0;
        
        while(current<size){
            int left = -1;
            int right = -1;
            
            for(int i=0; i<B; i++){
                if(current-i < 0){
                    continue;
                }
                if(A.get(current-i) == 1){
                    left = current-i;
                    break;
                }
            }
            
            for(int i=B-1; i>0; i--){
                if(current+i>size){
                    continue;
                }
                if(A.get(current+i) == 1){
                    right = current+i;
                    break;
                }
            }
            
            if(left == -1 && right == -1){
                return -1;
            }else if(right != -1){
                count++;
                current = right+B;
            }else {
                count++;
                current = left+B;
            }
        }
        
        return count;
    }

}
