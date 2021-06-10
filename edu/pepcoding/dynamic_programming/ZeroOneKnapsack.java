package edu.pepcoding.dynamic_programming;

import java.util.Scanner;

public class ZeroOneKnapsack {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] values = new int[n];
    int[] weight = new int[n];

    for (int i = 0; i < n; i++) {
      values[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      weight[i] = sc.nextInt();
    }

    int capacity = sc.nextInt();

    System.out.println(getMaxProfit(values, weight, capacity));
  }

  private static int getMaxProfit(int[] values, int[] weight, int capacity) {
    int size = values.length;
    int[][] dp = new int[size+1][capacity+1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if(i==0 || j==0){
          dp[i][j] = 0;
        }else if(weight[i-1]<=j){
          dp[i][j] = Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-weight[i-1]] );
        }else{
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    return dp[size][capacity];
  }
}
