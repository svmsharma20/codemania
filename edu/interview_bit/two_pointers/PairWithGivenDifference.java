package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class PairWithGivenDifference {

    public static void main(String[] args) {
        int[] a = {1, 2, 7, 5, 9, 15 };
        ArrayList<Integer> aList = new ArrayList<>();
        int diff = 10;
        for (int n : a) {
            aList.add(n);
        }

        System.out.println(isDiffPresent(aList, diff));
    }

    private static int isDiffPresent(ArrayList<Integer> aList, int diff) {

        sort(aList, 0, aList.size()-1);

        int left = 0;
        int right = 1;

        while (left<aList.size() && right<aList.size()){
            int d = aList.get(right) - aList.get(left);

            if(left!= right && d==diff){
                return 1;
            }else if (d<diff){
                right++;
            }else{
                left++;
            }
        }

        return 0;
    }

    private static void sort(ArrayList<Integer> aList, int start, int end) {
        if(start==end){
            return;
        }

        int mid = start + (end-start)/2;

        sort(aList,start, mid);
        sort(aList, mid+1, end);

        int i=start;
        int j=mid+1;

        ArrayList<Integer> temp = new ArrayList<>();

        while (i<=mid && j<=end){
            if(aList.get(i)<=aList.get(j)){
                temp.add(aList.get(i));
                i++;
            }else {
                temp.add(aList.get(j));
                j++;
            }
        }

        while (i<=mid){
            temp.add(aList.get(i));
            i++;
        }

        while (j<=end){
            temp.add(aList.get(j));
            j++;
        }

        for (int p = 0, q=start; p < temp.size() && q<=end; p++, q++) {
            aList.set(q, temp.get(p));
        }
    }

}
