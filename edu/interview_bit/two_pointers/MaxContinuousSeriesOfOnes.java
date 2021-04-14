package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class MaxContinuousSeriesOfOnes {

    /*
    * https://www.youtube.com/watch?v=QPfalDbqa4A
    * */

    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1, 0, 1, 1, 0};
        int numOfFlipsAllowed = 2;

        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }
        System.out.println(maxOne(aList, numOfFlipsAllowed));
    }

    private static ArrayList<Integer> maxOne(ArrayList<Integer> aList, int flipCount) {

        int index = 0;
        int maxOnes = 0;
        int left = -1;
        int count = 0;
        for (int right = 0; right < aList.size(); right++) {
            if(aList.get(right)==0){
                count++;
            }

            while (count>flipCount){
                left++;
                if(aList.get(left)==0){
                    count--;
                }
            }

            int len = right-left;
            if (len>maxOnes){
                maxOnes=len;
                index=left+1;
            }
        }

        ArrayList<Integer> maxOnesIndices = new ArrayList<>();

        for (int i = 0; i < maxOnes; i++) {
            maxOnesIndices.add(index+i);
        }

        return maxOnesIndices;
    }

}
