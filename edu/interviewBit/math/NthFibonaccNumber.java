package edu.interviewBit.math;

public class NthFibonaccNumber {
    
    long modulous = (long)Math.pow(10,9) + 7;
    
    public static void main(String[] args) {
        System.out.println(new NthFibonaccNumber().solve(10));
    }
    
    public int solve(int A) {
        if(A==1 || A==2){
            return 1;
        }
        
        long[][] nthMatrix = nThPowerOfBaseMatrix(A);
        
        return (int)nthMatrix[0][1];
    }
    
    long[][] nThPowerOfBaseMatrix(long n){
        long[][] pow = {{1,1},{1,0}};
        long[][] mat = {{1,0},{0,1}};
    
        long num = 1;
        
        while(num<=n){
            if((n&num) >0){
                long temp1[][] = new long[2][2];        
                    
                temp1[0][0] = ( (mat[0][0]*pow[0][0]) % modulous + (mat[0][1]*pow[1][0]) % modulous) % modulous;
                temp1[0][1] = ( (mat[0][0]*pow[0][1]) % modulous + (mat[0][1]*pow[1][1]) % modulous) % modulous;
                temp1[1][0] = ( (mat[1][0]*pow[0][0]) % modulous + (mat[1][1]*pow[1][0]) % modulous) % modulous;
                temp1[1][1] = ( (mat[1][0]*pow[0][1]) % modulous + (mat[1][1]*pow[1][1]) % modulous) % modulous;

                mat[0][0] = temp1[0][0];
                mat[0][1] = temp1[0][1];
                mat[1][0] = temp1[1][0];
                mat[1][1] = temp1[1][1];

            }
            long temp[][] = new long[2][2];
            temp[0][0] = ((pow[0][0]*pow[0][0]) % modulous  + (pow[0][1]*pow[1][0]) % modulous ) % modulous ;
            temp[0][1] = ((pow[0][0]*pow[0][1]) % modulous  + (pow[0][1]*pow[1][1]) % modulous ) % modulous ;
            temp[1][0] = ((pow[1][0]*pow[0][0]) % modulous  + (pow[1][1]*pow[1][0]) % modulous ) % modulous ;
            temp[1][1] = ((pow[1][0]*pow[0][1]) % modulous  + (pow[1][1]*pow[1][1])% modulous ) % modulous ;
            
            pow[0][0] = temp[0][0];
            pow[0][1] = temp[0][1];
            pow[1][0] = temp[1][0];
            pow[1][1] = temp[1][1];
            
            
            num = num<<1;
        }
        
        return mat;
    }
}
