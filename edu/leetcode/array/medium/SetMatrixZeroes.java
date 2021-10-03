package edu.leetcode.array.medium;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
        boolean atZeroZero = false;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    if(j==0){
                        atZeroZero = true;
                    }else{
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        
        for(int i=matrix.length-1; i>=0; i--){
            for(int j=matrix[i].length-1; j>=0; j--){
                if(j==0){
                    if(atZeroZero)
                        matrix[i][j] = 0;
                }else if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
