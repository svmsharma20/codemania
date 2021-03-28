package edu.interview_bit.array;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        
        Collections.sort(A);
        int size=A.size();
        for(int i=0; i<size-1; i+=2){
            int temp = A.get(i);
            A.set(i, A.get(i+1));
            A.set(i+1, temp);
        }
        
        return A;
    }
}
