package edu.interview_bit.bit_manipulation;

import java.util.ArrayList;

public class MinXORValue {

    public static void main(String[] args) {
        int[] numArr = {0, 2, 5, 7};
        ArrayList<Integer> numList = new ArrayList<>();
        for (int n: numArr) {
            numList.add(n);
        }
        System.out.println(findMinXor(numList));
    }

    private static int findMinXor(ArrayList<Integer> numList) {

        sort(numList, 0, numList.size()-1);

        int minXOR = Integer.MAX_VALUE;
        for (int i = 1; i < numList.size(); i++) {
            int localXOR = numList.get(i) ^ numList.get(i-1);
            if(localXOR<minXOR){
                minXOR = localXOR;
            }
        }
        return minXOR;
    }

    private static void sort(ArrayList<Integer> list, int start, int end){

        if(start==end){
            return;
        }

        int mid = start + (end-start)/2;

        sort(list, start, mid);
        sort(list, mid+1, end);

        int i=start;
        int j=mid+1;
        ArrayList<Integer> temp = new ArrayList<>();

        while(i<=mid && j<=end){
            if(list.get(i)<=list.get(j)){
                temp.add(list.get(i));
                i++;
            }else{
                temp.add(list.get(j));
                j++;
            }
        }

        while(i<=mid){
            temp.add(list.get(i));
            i++;
        }

        while(j<=end){
            temp.add(list.get(j));
            j++;
        }

        for (int p = 0, q=start; p<temp.size() && q<=end ; p++, q++) {
            list.set(q, temp.get(p));
        }
    }
}
