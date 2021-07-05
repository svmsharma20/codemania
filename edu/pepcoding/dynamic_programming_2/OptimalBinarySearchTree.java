package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class OptimalBinarySearchTree {

  private static void optimalbst(int[] keys, int[] frequency, int n) {

    int[] prefix = new int[n];
    prefix[0] = frequency[0];
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + frequency[i];
    }

    int[][] dp = new int[n][n];

    for (int g = 0; g < n; g++) {
      for (int i = 0, j = g; j < n; j++, i++) {
        if (g == 0) {
          dp[i][j] = frequency[i];
        } else if (g == 1) {
          int f1 = frequency[i];
          int f2 = frequency[j];

          dp[i][j] = Math.min((f1 + 2 * f2), (f2 + 2 * f1));
        } else {
          int min = Integer.MAX_VALUE;
          for (int k = i; k <= j; k++) {
            if (k == i) {
              min = Math.min(min, dp[k + 1][j]);
            } else if (k == j) {
              min = Math.min(min, dp[i][k - 1]);
            } else {
              min = Math.min(min, dp[i][k - 1] + dp[k + 1][j]);
            }
          }
          if (i == 0) {
            dp[i][j] = min + prefix[j];
          } else {
            dp[i][j] = min + prefix[j] - prefix[i - 1];
          }

        }
      }
    }

    System.out.println(dp[0][n - 1]);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] keys = new int[n];
    int[] frequency = new int[n];
    for (int i = 0; i < n; i++) {
      keys[i] = scn.nextInt();
    }
    for (int i = 0; i < n; i++) {
      frequency[i] = scn.nextInt();
    }
    optimalbst(keys, frequency, n);
  }

}
