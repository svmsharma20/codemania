package edu.interview_bit.array;

public class MaximumSumSquareSubMatrix {
    
    public int solve(int[][] mat, int B) {
        
        int n = mat.length;
        
        int[][] sumMatrix = new int[n+1][n+1];
        
        for(int i=1; i<sumMatrix.length; i++){
            for(int j=1; j<sumMatrix.length; j++){
                sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + mat[i-1][j-1];
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=B; i<sumMatrix.length; i++){
            for(int j=B; j<sumMatrix.length; j++){
                int sum = sumMatrix[i][j] - sumMatrix[i][j-B] - sumMatrix[i-B][j] + sumMatrix[i-B][j-B];
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
    
}
