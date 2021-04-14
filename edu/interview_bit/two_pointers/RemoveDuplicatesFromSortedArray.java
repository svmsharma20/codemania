package edu.interview_bit.two_pointers;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 3, 3};

        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        System.out.println(removeDuplicates(aList));
    }

    private static int removeDuplicates(ArrayList<Integer> aList) {
        int i=0;
        int j=-1;

        while (i<aList.size()){
            if(i<aList.size()-1 && aList.get(i).intValue()!=aList.get(i+1).intValue()){
                aList.set(++j, aList.get(i));
            }
            i++;
        }

        aList.set(++j, aList.get(aList.size()-1));

        j++;

        while(j<aList.size()){
            aList.remove(aList.size()-1);
        }
        return aList.size();
    }

}
