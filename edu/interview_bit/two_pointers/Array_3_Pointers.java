package edu.interview_bit.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class Array_3_Pointers {

    public static void main(String[] args) {
        int[] a = {1, 4, 10};
        int[] b = {2, 15, 20};
        int[] c = {10, 12};

        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        ArrayList<Integer> cList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        for (int n : b) {
            bList.add(n);
        }

        for (int n : c) {
            cList.add(n);
        }

        System.out.println(minimize(aList, bList, cList));
    }

    private static int minimize(final List<Integer> aList, final List<Integer> bList, final List<Integer> cList) {
        int i=0;
        int j=0;
        int k=0;

        int minDiff = Integer.MAX_VALUE;

        while (i<aList.size() && j<bList.size() && k<cList.size()){
            int a = aList.get(i);
            int b = bList.get(j);
            int c = cList.get(k);

            int maxDiffForCurrentValues = Math.max(Math.max(Math.abs(a-b), Math.abs(b-c)), Math.abs(c-a));

            if(maxDiffForCurrentValues < minDiff){
                minDiff = maxDiffForCurrentValues;
            }

            if(a<=b && a<=c){
                i++;
            }else if(b<=a && b<=c){
                j++;
            }else {
                k++;
            }
        }

        return minDiff;
    }

}
