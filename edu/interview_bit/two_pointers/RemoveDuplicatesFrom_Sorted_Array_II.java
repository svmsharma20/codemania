package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class RemoveDuplicatesFrom_Sorted_Array_II {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2, 3, 3, 4};

        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        System.out.println(removeDuplicates(aList));
    }

    private static int removeDuplicates(ArrayList<Integer> aList) {
        int i=1;
        int j=0;
        int count=1;

        while (i<aList.size()){
            if(aList.get(i).equals(aList.get(i-1))){
                count++;
            }else{
                count=1;
            }

            if(count<=2){
                aList.set(++j, aList.get(i));
            }
            i++;
        }
        while (j<aList.size()-1){
            aList.remove(aList.size()-1);
        }

        return aList.size();
    }

}
