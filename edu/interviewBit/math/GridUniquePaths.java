package edu.interviewBit.math;

public class GridUniquePaths {
    public int uniquePaths(int A, int B) {
        
        int[][] matrix = new int[A][B];
        
        for(int i=0; i<A; i++){
            for(int j=0; j<B; j++){
                if(i==0 && j==0){
                    matrix[0][0] = 1;            
                }else if(i!=0 && j!=0){
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }else if(i==0){
                    matrix[i][j] = matrix[i][j-1];
                }else if(j==0){
                    matrix[i][j] = matrix[i-1][j];
                } 
            }
        }
        
        return matrix[A-1][B-1];
        
    }
}
