package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class MinSquares {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-squares-official/ojquestion
  // https://youtu.be/aZuQXkO0-XA?list=TLGGUoqM0XRTkmEyMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(getMinCount(n));
  }

  private static int getMinCount(int n) {
    int[] dp = new int[n+1];
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; (j*j) <= i; j++) {
        min = Math.min(min, dp[i-(j*j)]);
      }
      dp[i] = min+1;
    }

    return dp[n];
  }
}
