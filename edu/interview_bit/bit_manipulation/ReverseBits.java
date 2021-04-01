package edu.interview_bit.bit_manipulation;

public class ReverseBits {

    public static void main(String[] args) {
        long num = 3;
//        System.out.println(num);
        System.out.println(getReverseBitNumber(num));
    }

    private static long getReverseBitNumber(long num) {
        long reverse = 0;
        long checker = 1;
        for (int i = 0; i < 32; i++) {
            reverse <<=1;
            if((num&checker)==checker){
                reverse |= 1;
            }
            checker <<= 1;
        }
        return reverse;
    }
}
