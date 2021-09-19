package edu.interview_bit.bit_manipulation;

public class NumberOf_1_Bits {

    public static void main(String[] args) {
        long num = 11;
        System.out.println(getOneBitCount(num));
    }

    private static int getOneBitCount(long num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) > 0) {
                count++;
            }
            num >>= 1;
        }

        return count;
    }

    // more optimized way
    public int numSetBits(long a) {
        int count = 0;

        while (a > 0) {
            count++;
            a = a & (a - 1);
        }

        return count;
    }
}
