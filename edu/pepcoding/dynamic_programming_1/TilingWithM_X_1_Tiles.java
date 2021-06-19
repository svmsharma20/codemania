package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class TilingWithM_X_1_Tiles {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tiling2-official/ojquestion
  // https://youtu.be/_c_R-uIi-zU?list=TLGGSPv0JY5jlnQxMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(getTotalWaysToTile(n, m));
  }

  private static int getTotalWaysToTile(int n, int m) {
    if(n<=m){
      return 1;
    }

    int[] dp = new int[n+1];

    for (int i = 1; i <= n ; i++) {
      if(i<m){
        dp[i] = 1;
      }else if(i==m){
        // For i==m there are two ways, either all tiles horizontally or all vertically;
        dp[i] = 2;
      }else{
        dp[i] = dp[i - 1] + dp[i - m];
      }
    }
    return dp[n];
  }
}
