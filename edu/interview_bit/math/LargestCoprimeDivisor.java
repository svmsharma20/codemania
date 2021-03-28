package edu.interview_bit.math;

public class LargestCoprimeDivisor {
    public int cpFact(int A, int B) {
        int g = gcd(A,B);
        while(g != 1){
            A = A/g;
            g = gcd(A,B);
        }
        
        return A;
    }
    
    public int gcd(int a, int b){
        if(b==0)
            return a;
            
        return gcd(b, a%b);
    }
}
