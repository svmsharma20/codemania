package edu.interview_bit.bit_manipulation;

public class TrailingZeroes {

    public static void main(String[] args) {
        int n=18;
        System.out.println(getTrailingZeros(n));
    }

    private static int getTrailingZeros(int n) {
        int count=0;

        while((n&1)==0){
            count += ((n & 1)==0) ? 1 : 0;
            n >>= 1;
        }

        return count;
    }
}
