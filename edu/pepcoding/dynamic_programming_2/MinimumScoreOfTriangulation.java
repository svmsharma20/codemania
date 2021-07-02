package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/minimum-score-of-triangulation-official/ojquestion
// https://www.youtube.com/watch?v=tmIhmeL8WRo&list=TLGGic3FVQW5CkEwMjA3MjAyMQ
public class MinimumScoreOfTriangulation {

  public static int minScoreTriangulation(int[] arr) {
    int[][] dp = new int[arr.length][arr.length];

    for (int g = 0; g <= dp.length; g++) {
      for (int i = 0, j = g; j < dp[0].length; i++, j++) {
        if (g == 0 || g == 1) {
          dp[i][j] = 0;
        } else if (g == 2) {
          dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
        } else {
          int minCost = Integer.MAX_VALUE;

          for (int k = i + 1; k < j; k++) {
            int tri = arr[i] * arr[j] * arr[k];
            int left = dp[i][k];
            int right = dp[k][j];
            int cost = tri + left + right;
            minCost = Math.min(minCost, cost);
          }

          dp[i][j] = minCost;
        }
      }
    }

    return dp[0][dp.length - 1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
  }
}