package edu.interview_bit.bit_manipulation;

/*
* https://www.youtube.com/watch?v=QYoWR8hDCyQ
* */

public class PalindromicBinaryRepresentation {

    public static void main(String[] args) {
        int n = 9;
        System.out.println(getNthPalindromicBinaryRepresentation(n));
    }

    private static int getNthPalindromicBinaryRepresentation(int n) {
        int len=0;
        int count=0;
        while (count<n){
            len++;
            int elementsOfCurrentLen = 1 << ((len-1)/2);
            count += elementsOfCurrentLen;
        }

        count -= (1 << ((len-1)/2));
        int offset = n-count-1;

        int ans = (1 << (len-1));
        ans |= (offset << (len/2));

        int rightHalf = (ans >> (len/2));
        int rev = getBinaryReverse(rightHalf);

        ans |= rev;

        return ans;
    }

    private static int getBinaryReverse(int num) {
        int rev = 0;
        while(num != 0){
            int leftBit = (num & 1);
            rev |= leftBit;
            rev <<= 1;
            num >>= 1;
        }

        rev >>= 1;
        return rev;
    }
}
