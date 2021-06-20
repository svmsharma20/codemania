package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class MaximumSumIncreasingSubsequence {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(getMaxSumOfIS(arr));
  }

  private static int getMaxSumOfIS(int[] arr) {
    int[] dp = new int[arr.length];
    int maxSum = arr[0];

    for (int i = 0; i < arr.length; i++) {
      int localMax = 0;
      for (int j = 0; j < i; j++) {
        if(arr[j]<=arr[i]){
          localMax = Math.max(localMax, dp[j]);
        }
      }
      dp[i] = localMax + arr[i];
      maxSum = Math.max(maxSum, dp[i]);
    }

    return maxSum;
  }
}
