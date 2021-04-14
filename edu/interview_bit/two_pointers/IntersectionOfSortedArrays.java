package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class IntersectionOfSortedArrays {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4, 5, 6};
        int[] b = {3, 3, 3, 5};

        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        for (int n : b) {
            bList.add(n);
        }

        System.out.println(intersect(aList, bList));
    }

    private static ArrayList<Integer> intersect(ArrayList<Integer> aList, ArrayList<Integer> bList) {
        ArrayList<Integer> intersectionList = new ArrayList<>();
        int i=0;
        int j=0;

        while(i<aList.size() && j<bList.size()){
            if (aList.get(i)<bList.get(j)){
                i++;
            }else if(aList.get(i)>bList.get(j)){
                j++;
            }else{
                intersectionList.add(aList.get(i));
                i++;
                j++;
            }
        }

        return intersectionList;
    }
}
