package edu.interview_bit.bit_manipulation;

import java.util.ArrayList;

public class DifferentBitsSumPairwise {

    public static void main(String[] args) {
        int[] numArray = {81, 13, 2, 7, 96};
        ArrayList<Integer> numList = new ArrayList<>();

        for (int n: numArray) {
            numList.add(n);
        }
        System.out.println(cntBits(numList));
    }

    private static int cntBits(ArrayList<Integer> numList) {
        long ans=0;
        int checker = 1;
        long size = numList.size();
        long modulo = (long)Math.pow(10,9)+7;
        for (int i = 0; i < 31; i++) {
            long count=0;
            for(int n : numList){
                // count no. of zeros
                if((n&checker)==0){
                    count++;
                }
            }
            ans += 2*(count*(size-count));
            ans %= modulo;
            checker <<= 1;
        }

        return (int)ans;
    }
}
