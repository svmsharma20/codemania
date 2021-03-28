package edu.interview_bit.array;

import java.util.ArrayList;

public class SetMatrixZeros {
    
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean flag = false;
        
        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(i).size(); j++){
                if(a.get(i).get(j) != 0){
                    continue;
                }
                
                if(j==0){
                    flag = true;
                }else{
                    a.get(i).set(j, 0);
                    a.get(0).set(i, 0);
                }
            }
        }
        
        for(int i=a.size()-1; i>=0; i--){
            for(int j=a.get(i).size()-1; j>=0; j--){
                if(j==0){
                    if(flag){
                        a.get(i).set(j, 0);    
                    }
                }else if(a.get(i).get(0) == 0 || a.get(0).get(j)==0){
                    a.get(i).set(j, 0);
                }
            }
        }
        
    }

}
