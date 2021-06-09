package edu.pepcoding.dynamic_programming;

import java.util.Scanner;

public class ClimbStairsWithVariableJumps {

 // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-variable-jumps-official/ojquestion
  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i] = sc.nextInt();
    }

    System.out.println(getTotalPath(n, arr));
  }

  public static int getTotalPath(int n, int[] arr){
    int[] dp = new int[n+1];
    dp[n] = 1;
    for(int i=n-1; i>=0; i--){
      for(int j=1; j<=arr[i] && (i+j)<dp.length; j++){
        dp[i] += dp[i+j];
      }
    }

    return dp[0];
  }
}
