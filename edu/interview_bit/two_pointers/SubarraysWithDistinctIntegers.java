package edu.interview_bit.two_pointers;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraysWithDistinctIntegers {

    // https://www.geeksforgeeks.org/count-of-subarrays-having-exactly-k-distinct-elements/

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 2, 3 };
        ArrayList<Integer> aList = new ArrayList<>();
        int k = 1;
        for (int n : a) {
            aList.add(n);
        }

        System.out.println(countSubarraysWithExactlyKDistinctIntegers(aList, k));
    }

    private static int countSubarraysWithExactlyKDistinctIntegers(ArrayList<Integer> aList, int k) {
        return countSubarrayWithAtMostKDistinctInteger(aList, k) -
                countSubarrayWithAtMostKDistinctInteger(aList, k-1);
    }

    private static int countSubarrayWithAtMostKDistinctInteger(ArrayList<Integer> aList, int k) {
        int left=0;
        int right=0;
        int count = 0;

        HashMap<Integer, Integer> integerCount = new HashMap<>();

        while (right<aList.size()){
            integerCount.put(aList.get(right), integerCount.getOrDefault(aList.get(right), 0)+1);

            while (integerCount.size()>k){
                integerCount.put(aList.get(left), integerCount.get(aList.get(left))-1);
                if(integerCount.get(aList.get(left))==0){
                    integerCount.remove(aList.get(left));
                }
                left++;
            }
            count += (right-left+1);
            right++;
        }

        return count;
    }


}
