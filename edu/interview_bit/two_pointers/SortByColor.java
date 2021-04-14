package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class SortByColor {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 0, 1, 2};

        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }
        sortColors(aList);
        System.out.println(aList);
    }

    private static void sortColors(ArrayList<Integer> aList) {
        int i=-1;
        int j=0;
        int k=aList.size();

        while (j<k){
            switch (aList.get(j).intValue()){
                case 0:
                    i++;
                    int temp1 = aList.get(i);
                    aList.set(i, aList.get(j));
                    aList.set(j, temp1);
                    j++;
                    break;

                case 1:
                    j++;
                    break;

                case 2:
                    k--;
                    int temp2 = aList.get(k);
                    aList.set(k, aList.get(j));
                    aList.set(j, temp2);
                    break;
            }
        }
    }

}
