package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class MaximumOnesAfterModification {

    public static void main(String[] args) {
        int[] a = {1, 0, 0, 1, 0, 1, 1, 0};
        int numOfFlipsAllowed = 2;

        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }
        System.out.println(maxOne(aList, numOfFlipsAllowed));
    }

    private static int maxOne(ArrayList<Integer> aList, int numOfFlipsAllowed) {
        int right=0;
        int left=-1;
        int maxLen = 0;
        int count=0;

        while (right<aList.size()){
            if(aList.get(right)==0){
                count++;
            }

            while (count > numOfFlipsAllowed){
                left++;
                if(aList.get(left)==0){
                    count--;
                }
            }

            int len = right-left;
            if(len>maxLen){
                maxLen = len;
            }
            right++;
        }

        return maxLen;
    }

}
