package edu.interview_bit.two_pointers;

import java.util.*;

public class Merge_Two_Sorted_Lists_II {

    public static void main(String[] args) {
        int[] a = {1, 5, 8};
        int[] b = {6, 9};

        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        for (int n : b) {
            bList.add(n);
        }

        merge(aList, bList);

        System.out.println(aList);
    }

    private static void merge(List<Integer> a, List<Integer> b) {
        int i=0;
        int j=0;

        while(i<a.size() && j<b.size()){
            if(a.get(i) <= b.get(j)){
                i++;
            }else{
                a.add(i, b.get(j));
                i++;
                j++;
            }
        }

        while(j<b.size()){
            a.add(b.get(j));
            i++;
            j++;
        }
    }
}
