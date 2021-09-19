package edu.interview_bit.bit_manipulation;

public class CountTotalSetBits {

    //  https://www.youtube.com/watch?v=g6OxU-hRGtY

    public static void main(String[] args) {
        int n = 11;
        System.out.println(getTotalSetBits(n));
    }

    private static int getTotalSetBits(int n) {
        long p=0;
        long count=0;
        long modulo = 1000000007;
        while(n>0){

            p=0;
            // (1<<p) is for finding the largest 2's power but smaller than the n
            while((1<<p)<=n){
                p++;
            }
            p--;
            count += p * (1 << (p - 1)) + (n - (1 << p) + 1);
            count %= modulo;
            n = n - (1 << p);

        }
        return (int) (count % modulo);
    }

    // both codes are same
    public static int countSetBits(int n) {

        int count = 0;
        while (n > 0) {
            int k = 1;
            int pow = 0;
            while (n >= k) {
                k <<= 1;
                pow++;
            }
            pow--;
            k >>= 1;
            count += (pow * k) / 2 + (n - k + 1);
            n = n - k;
        }

        return count;

    }
}
