package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class RemoveElementFromArray {

    public static void main(String[] args) {
        int[] a = {4, 1, 1, 1, 2, 3, 3};
        int num = 1;
        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        System.out.println(removeElement(aList, num));
    }

    private static int removeElement(ArrayList<Integer> aList, int num) {
        int i=0;
        int j=-1;

        while (i<aList.size()){
            if(aList.get(i).intValue()!=num){
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
