package edu.interview_bit.array;

import java.util.ArrayList;

public class PascalTriangle {
    
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i=0; i<A; i++){
            temp.add(0, 1);
            for(int j=1; j<temp.size()-1; j++){
                temp.set(j, temp.get(j)+temp.get(j+1)); 
            }
            
            list.add(new ArrayList<Integer>(temp));
        }
        
        return list;
    }

}
