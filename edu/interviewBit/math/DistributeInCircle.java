package edu.interviewBit.math;

public class DistributeInCircle {
    
    public int solve(int A, int B, int C) {
        int remainingPlacesToCoverAfterFullCircles = A % B;
        remainingPlacesToCoverAfterFullCircles--;
        return (C+remainingPlacesToCoverAfterFullCircles)%B;
    }
    
}
