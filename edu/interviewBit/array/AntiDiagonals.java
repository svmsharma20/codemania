package edu.interviewBit.array;

import java.util.ArrayList;

public class AntiDiagonals {
    
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        
        ArrayList<ArrayList<Integer>> diagonalList = new ArrayList<>();
        int size = A.size();
        int count=1;
        int row=0;
        boolean isIncreasing = true;
        
        while(row<size){
            
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int i=row, j=count-1; i<size && j>=0 ; i++, j--){
                list.add(A.get(i).get(j));
            }
            
            diagonalList.add(list);
            
            if(count<size && isIncreasing){
                count++;
            }else{
                isIncreasing = false;
                count--;
                row++;
            }
        }
        
        return diagonalList;
    }
    
}
