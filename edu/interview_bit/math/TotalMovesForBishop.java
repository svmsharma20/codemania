package edu.interview_bit.math;

public class TotalMovesForBishop {
    public int solve(int A, int B) {
        int totalMoves = 0;
        int movesToTopLeft = Math.min(A, B)-1;
        int movesToTopRight = Math.min(A, 9-B)-1;
        int movesToBottomLeft = 8 - Math.max(A, 9-B);
        int movesToBottomRight = 8 - Math.max(A, B);
        
        totalMoves = movesToTopLeft + movesToTopRight + movesToBottomLeft + movesToBottomRight;
        return totalMoves;
    }
}
