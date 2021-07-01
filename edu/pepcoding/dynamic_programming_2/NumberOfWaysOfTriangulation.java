package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class NumberOfWaysOfTriangulation {

  public static int solution(int n){
    n = n-2;

    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;

    for( int i = 2; i <= n; i++){
      int p = 0;
      int q = i-1;

      while(p<q){
        dp[i] += 2 * dp[p] * dp[q];
        p++;
        q--;
      }

      if(p==q){
        dp[i] += dp[p] * dp[p];
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }

}
