package edu.interview_bit.math;

public class GreatestCommonDivisor {
    public int gcd(int A, int B) {
        if(A==0){
            return B;
        }
        if(B==0){
            return A;
        }
        
        if(A==B){
            return A;
        }
        
        if(A>B){
            return gcd(A-B,B);
        }
        
        return gcd(A,B-A);
    }
}
