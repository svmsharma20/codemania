package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 4, 3 };
        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        System.out.println(maxArea(aList));
    }

    private static int maxArea(ArrayList<Integer> aList) {
        int left = 0;
        int right = aList.size()-1;
        int maxArea = 0;

        while (left<right){
            int heightUpToWaterCanBeFilled = Math.min(aList.get(left), aList.get(right));
            int area = heightUpToWaterCanBeFilled * (right-left);
            if(area>maxArea){
                maxArea = area;
            }

            if(aList.get(left)<= aList.get(right)){
                left++;
            }else{
                right--;
            }

        }

        return maxArea;
    }
}
