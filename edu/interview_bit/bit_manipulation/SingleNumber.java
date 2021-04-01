package edu.interview_bit.bit_manipulation;

/*
* https://www.youtube.com/watch?v=krgK0UlfNYY
* */

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2};
        System.out.println(getSingleNumber(arr));
    }

    private static int getSingleNumber(int[] arr) {
        int xor = 0;
        for (int n : arr) {
            xor ^= n;
        }
        return xor;
    }
}
