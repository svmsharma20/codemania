package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class MaximumSumNonAdjacentElements {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/maximum-sum-non-adjacent-elements-official/ojquestion
  // https://youtu.be/VT4bZV24QNo?list=TLGG-g-kz4wW-7wxMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(getMaxSumNonAdjacent(arr));
  }

  private static int getMaxSumNonAdjacent(int[] arr) {
    final int INCLUDE = 0;
    final int EXCLUDE = 1;

    int[][] dp = new int[2][arr.length];
    dp[INCLUDE][0] = arr[0];
    dp[EXCLUDE][0] = 0;

    for (int i = 1; i < arr.length; i++) {
      dp[INCLUDE][i] = arr[i] + dp[EXCLUDE][i-1];
      dp[EXCLUDE][i] = Math.max(dp[INCLUDE][i-1], dp[EXCLUDE][i-1]);
    }

    return Math.max(dp[INCLUDE][arr.length-1], dp[EXCLUDE][arr.length-1]);
  }
}
