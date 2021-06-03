package edu.interview_bit.greedy_algorithms;

import java.util.Arrays;

public class LargestPermutation {

  public static void main(String[] args) {

  }

  // Even the fastest solution is not working from Complete Solution
  public int[] solve(int[] A, int B) {

      if(B==0){
        return A;
      }

      int[] arr = new int[A.length];
      int[] indices = new int[arr.length+1];

      for (int i = 0; i < A.length; i++) {
        arr[i] = A[i];
        indices[A[i]] = i;
      }
      mergeSort(arr, 0, arr.length-1);

      if(B>A.length){
        return arr;
      }

      int index = 0;
      int i=0;
      while(B>0 && i< A.length){
        if(A[i]<arr[index]){
          int indexOfIndexth = indices[arr[index]];
          int temp = A[i];
          A[i] = A[indexOfIndexth];
          A[indexOfIndexth] = temp;
          indices[temp] = indexOfIndexth;
          indices[A[i]] = i;
          index++;
          B--;
        }else if(A[i]==arr[index]){
          index++;
        }
        i++;
      }

      return A;

    }

    private void mergeSort(int[] arr, int start, int end){
      if(start < end){
        int mid = start + (end-start)/2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        int i=start;
        int j=mid+1;
        int k=0;
        int[] temp = new int[end-start+1];

        while(i<=mid && j<=end){
          if(arr[i] >= arr[j]){
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
