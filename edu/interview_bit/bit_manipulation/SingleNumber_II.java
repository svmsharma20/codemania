package edu.interview_bit.bit_manipulation;

/*
* https://www.youtube.com/watch?v=cOFAmaMBVps
* */

public class SingleNumber_II {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(getSingleNumber(arr));
    }

    private static int getSingleNumber(int[] arr) {
        int ans = 0;
        int checker = (1<<31);

        for (int i = 0; i < 32; i++) {
            int noOfOneBitsAtIthPosition = 0;
            for (int n : arr) {
                noOfOneBitsAtIthPosition += ((n & checker)==0) ? 0 : 1;
            }
            checker >>>= 1;
            ans |= (noOfOneBitsAtIthPosition % 3);
            if (i != 31) {
                ans <<= 1;
            }
        }

        return ans;
    }

    // optimized solution
    public int singleNumber(final int[] A) {
        // https://www.youtube.com/watch?v=3gJxLkPPW6M

        int threeN = Integer.MAX_VALUE;
        int threeNPlusOne = 0;
        int threeNPlusTwo = 0;

        for (int i = 0; i < A.length; i++) {
            int threeNCommon = (A[i] & threeN);
            int threeNPlusOneCommon = (A[i] & threeNPlusOne);
            int threeNPlusTwoCommon = (A[i] & threeNPlusTwo);

            threeN ^= threeNCommon;
            threeNPlusOne |= threeNCommon;

            threeNPlusOne ^= threeNPlusOneCommon;
            threeNPlusTwo |= threeNPlusOneCommon;

            threeNPlusTwo ^= threeNPlusTwoCommon;
            threeN |= threeNPlusTwoCommon;
        }

        return threeNPlusOne;
    }
}
