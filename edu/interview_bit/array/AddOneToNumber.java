package edu.interview_bit.array;

import java.util.ArrayList;
import java.util.Iterator;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        
        for(int i=A.size()-1; i>=0; i--){
            if(A.get(i)==9){
                A.set(i, 0);
            }else{
                A.set(i, A.get(i)+1);
                return A;
            }
        }
        
        A.add(0, new Integer(1));
        
        Iterator<Integer> itr = A.iterator();
        while(itr.hasNext()){
            if(itr.next() != 0){
                break;
            }
            itr.remove();
        }
        
        return A;
    }
}
