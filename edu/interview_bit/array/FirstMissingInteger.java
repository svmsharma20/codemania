package edu.interview_bit.array;

import java.util.ArrayList;

public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
        
        for(int i=0; i<A.size(); i++){
            while(A.get(i)>0 && A.get(i)<=A.size() && A.get(i)-1!= i && A.get(i)!=A.get(A.get(i)-1)){
                int temp = A.get(A.get(i)-1);
                A.set(A.get(i)-1, A.get(i));
                A.set(i, temp);
            }
        }

        for(int i=0; i<A.size(); i++){
            if(i!=A.get(i)-1){
                return i+1;
            }
        }
        
        return A.size()+1;
    }
}
