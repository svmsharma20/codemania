package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class LongestBitonicSubsequence {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(getLongestBitonicSubSequence(arr));
  }

  private static int getLongestBitonicSubSequence(int[] arr) {
    int[] lis = new int[arr.length];
    int[] lds = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if(arr[j]<arr[i]){
          max = Math.max(max, lis[j]);
        }
      }
      lis[i] = max + 1;
    }

    for (int i = arr.length-1; i >= 0; i--) {
      int max = 0;
      for (int j = i-1; j < arr.length; j++) {
        if(arr[j]<arr[i]){
          max = Math.max(max, lds[j]);
        }
      }
      lds[i] = max + 1;
    }

    int maxLen = 0;
    for (int i = 0; i < arr.length; i++) {
      maxLen = Math.max(maxLen, lis[i]+lds[i]);
    }

    return maxLen-1;
  }
}
