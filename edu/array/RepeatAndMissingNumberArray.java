package edu.array;

public class RepeatAndMissingNumberArray {
    
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,3};
        new RepeatAndMissingNumberArray().repeatedNumber(arr);   
    }

    public int[] repeatedNumber(final int[] A) {
        
        long sum = 0, sumSquares = 0;
        for (int i = 1; i <= A.length; i++) {
            sum += A[i-1] - i;
            sumSquares += A[i-1]*(long)A[i-1] - i*(long)i;
        }
        long AminusB = sum;
        long AplusB = sumSquares / sum;
        return new int[] {(int)((AplusB+AminusB)/2), (int)((AplusB-AminusB)/2)};
    }
}
