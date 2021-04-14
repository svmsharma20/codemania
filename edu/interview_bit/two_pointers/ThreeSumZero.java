package edu.interview_bit.two_pointers;

import java.util.ArrayList;

public class ThreeSumZero {

    public static void main(String[] args) {
//        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] a = {2147483647, -2147483648, -2147483648, 0, 1 };
        ArrayList<Integer> aList = new ArrayList<>();

        for (int n : a) {
            aList.add(n);
        }

        System.out.println(threeSumZero(aList));
    }

    private static ArrayList<ArrayList<Integer>> threeSumZero(ArrayList<Integer> aList) {
        sort(aList, 0, aList.size()-1);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int i=0;
        while (i<aList.size()-2){
            int j=i+1;
            int k=aList.size()-1;
            while (j<k){
                long sum = (long)aList.get(i) + (long)aList.get(j) + (long)aList.get(k);
                if(sum==0){
                    ArrayList<Integer> localList = new ArrayList<>();
                    localList.add(aList.get(i));
                    localList.add(aList.get(j));
                    localList.add(aList.get(k));

                    result.add(localList);
                    j++;
                    k--;
                    while (j<k && aList.get(j)== aList.get(j-1)){
                        j++;
                    }

                    while (k>j && aList.get(k)== aList.get(k+1)){
                        k--;
                    }
                }else if(sum<0){
                    j++;
                }else {
                    k--;
                }
            }
            i++;
            while (i<aList.size()-2 && aList.get(i).intValue()==aList.get(i-1).intValue()){
                i++;
            }
        }
        return result;
    }

    private static void sort(ArrayList<Integer> aList, int start, int end) {
        if(start==end){
            return;
        }

        int mid = start + (end-start)/2;

        sort(aList, start, mid);
        sort(aList, mid+1, end);

        int i=start;
        int j=mid+1;

        ArrayList<Integer> temp = new ArrayList<>();

        while(i<=mid && j<=end){
            if(aList.get(i)<= aList.get(j)){
                temp.add(aList.get(i));
                i++;
            }else{
                temp.add(aList.get(j));
                j++;
            }
        }

        while (i<=mid){
            temp.add(aList.get(i));
            i++;
        }

        while (j<=end){
            temp.add(aList.get(j));
            j++;
        }

        for (int p=start, q=0; p<=end && q<temp.size(); p++, q++) {
            aList.set(p, temp.get(q));
        }
    }
}
