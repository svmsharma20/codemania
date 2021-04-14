package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class ThreeSum {

    public static void main(String[] args) {
        int[] a = {-1, 2, 1, 4};
        int num = 1;

        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        System.out.println(threeSumClosest(aList, num));
    }

    private static int threeSumClosest(ArrayList<Integer> aList, int n) {

        sort(aList, 0, aList.size()-1);

        int closestSum = 0;
        int diffBetweenClosesAndActualInteger = Integer.MAX_VALUE;

        for (int i = 0; i < aList.size(); i++) {
            for (int j = i+1, k=aList.size()-1; j < k; ) {
                int sum = aList.get(i) + aList.get(j) + aList.get(k);
                if(Math.abs(sum-n)<diffBetweenClosesAndActualInteger){
                    diffBetweenClosesAndActualInteger = Math.abs(sum-n);
                    closestSum = sum;
                }
                if(sum<n){
                    j++;
                }else if(sum>n){
                    k--;
                }else{
                    return closestSum;
                }
            }
        }
        return closestSum;
    }

    private static void sort(ArrayList<Integer> aList, int start, int end) {
        if(start==end){
            return;
        }

        int mid = start + (end-start)/2;

        sort(aList, start, mid);
        sort(aList, (mid+1), end);

        int i=start;
        int j=mid+1;
        ArrayList<Integer> temp = new ArrayList<>();

        while(i<=mid && j<=end){
            if(aList.get(i)<= aList.get(j)){
                temp.add(aList.get(i));
                i++;
            }else{
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

        for (int p = 0, q=start; p < temp.size(); p++, q++) {
            aList.set(q, temp.get(p));
        }
    }
}
