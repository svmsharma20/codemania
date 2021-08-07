package edu.pepcoding.recursion;

import java.util.Scanner;

public class TargetSumSubsets {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int tar = sc.nextInt();
    printTargetSumSubsets(arr, 0, "", 0, tar);
  }

  // set is the subset
  // sos is sum of subset
  // tar is target
  public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {

    if (idx == arr.length) {
      if (sos == tar) {
        System.out.println(set + ".");
      }
      return;
    }

    int val = arr[idx];
    int sum = sos + val;
    idx++;
    printTargetSumSubsets(arr, idx, set + val + ", ", sum, tar);
    printTargetSumSubsets(arr, idx, set, sos, tar);


  }
}
