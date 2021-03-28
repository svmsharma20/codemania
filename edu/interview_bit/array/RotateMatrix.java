package edu.interview_bit.array;

import java.util.ArrayList;

public class RotateMatrix {
    
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        
        int[][] matrix = new int[a.size()][a.get(0).size()];
        
        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(i).size(); j++){
                matrix[i][j] = a.get(i).get(j);
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        int p=0;
        int q=matrix.length-1;
        while(p<q){
            for(int j=0; j<matrix.length; j++){
                int temp = matrix[j][p];
                matrix[j][p] = matrix[j][q];
                matrix[j][q] = temp;
            }
            p++;
            q--;
        }
        
        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(i).size(); j++){
                a.get(i).set(j, matrix[i][j]);
            }
        }
    }

}
