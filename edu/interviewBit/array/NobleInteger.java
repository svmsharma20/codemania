package edu.interviewBit.array;

import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        
        Collections.sort(A);
        int size = A.size();
        
        for(int i=0; i<size; i++){
            if(i<size-1 && A.get(i) == A.get(i+1)){
                continue;
            }
            
            if(A.get(i) == size-1-i){
                return 1;
            }
        }
        
        return -1;
        
    }
}
