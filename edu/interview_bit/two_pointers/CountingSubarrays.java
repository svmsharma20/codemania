package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class CountingSubarrays  {

    public static void main(String[] args) {
        int[] a = {1, 11, 2, 3, 4, 5, 15 };
        ArrayList<Integer> aList = new ArrayList<>();
        int sum = 10;
        for (int n : a) {
            aList.add(n);
        }

        System.out.println(countSubarrays(aList, sum));
    }

    private static int countSubarrays(ArrayList<Integer> aList, int sum) {
        int left=0;
        int right=0;
        int localSum = aList.get(0);
        int count=0;

        while (left<aList.size() && right<aList.size()){

            if(localSum<sum){
                right++;

                if(right>=left){
                    // Contiguous arrays in this step produced are (end – start). All the sub array ends at right-1.
                    count += (right-left);
                }

                if(right<aList.size()){
                    localSum += aList.get(right);
                }
            }else {
                localSum -= aList.get(left);
                left++;
            }
        }

        return count;
    }
}
