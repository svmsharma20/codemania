package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class TargetSumSubsets {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int target = sc.nextInt();

    System.out.println(isTargetSumPossible(arr, target));
  }

  private static boolean isTargetSumPossible(int[] arr, int target) {
    int n = arr.length;
    boolean[][] dp = new boolean[n+1][target+1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if(j==0){
          dp[i][j] = true;
        }else if(i==0){
          dp[i][j] = false;
        }else if(j < arr[i-1]){
          dp[i][j] = dp[i-1][j];
        }else if(dp[i-1][j] || dp[i-1][j - arr[i-1]]){
            dp[i][j] = true;
        }else{
          dp[i][j] = false;
        }
      }
    }

    return dp[n][target];
  }
}
