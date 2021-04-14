package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class Diffk {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4};
        int num = 0;

        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        System.out.println(diffPossible(aList, num));
    }

    private static int diffPossible(ArrayList<Integer> aList, int num) {

        int i=0;
        int j=1;

        while (i<aList.size() && j<aList.size()){
            if(i!=j && (aList.get(j)-aList.get(i))==num){
                return 1;
            }else if((aList.get(j)-aList.get(i))<num){
                j++;
            }else{
                i++;
            }
        }

        return 0;
    }
}
