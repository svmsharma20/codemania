package edu.concepts.sorting;

import java.util.Arrays;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] arr = {2,7,1,45,3,2,8,1};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = start + (end-start)/2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);

            int i=start;
            int j=mid+1;
            int k=0;
            int[] temp = new int[end-start+1];

            while(i<=mid && j<=end){
                if(arr[i] <= arr[j]){
                    temp[k] = arr[i];
                    i++;
                    k++;   
                }else{
                    temp[k] = arr[j];
                    j++;
                    k++;   
                }

            }

            while(i <= mid){
                temp[k] = arr[i];
                i++;
                k++;
            }

            while(j <= end){
                temp[k] = arr[j];
                j++;
                k++;
            }

            for(int p=0, q=start; p<temp.length && q<=end; p++, q++){
                arr[q] = temp[p];
            }
        }
    }
}
