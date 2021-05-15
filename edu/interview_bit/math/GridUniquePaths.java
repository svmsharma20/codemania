package edu.interview_bit.math;

public class GridUniquePaths {

    public static void main(String[] args) {
        System.out.println(new GridUniquePaths().uniquePathUsingCombinatrics(15, 9));
    }

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

    public int uniquePathUsingCombinatrics(int A, int B){
        // https://www.youtube.com/watch?v=t_f0nwwdg5o

        int N = A+B-2;
        int r = A-1;
        double result = 1;

        for(int i=1; i<=r; i++){
            result = (result * (N-r+i))/i;
        }
        return (int)result;
    }
}
