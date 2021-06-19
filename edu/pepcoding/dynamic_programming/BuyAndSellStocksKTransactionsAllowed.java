package edu.pepcoding.dynamic_programming;

import java.util.Scanner;

public class BuyAndSellStocksKTransactionsAllowed {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-kta---official/ojquestion
  // https://youtu.be/3YILP-PdEJA?list=TLGGRMbgO4jb3uMxOTA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] stocks = new int[n];

    for (int i = 0; i < n; i++) {
      stocks[i] = sc.nextInt();
    }

    int k = sc.nextInt();

    System.out.println(getMaxProfitWithKTransaction(stocks, k));
  }

  private static int getMaxProfitWithKTransaction(int[] stocks, int k) {
    int len = stocks.length;
    int[][] dp = new int[k+1][len];

    // t = transaction
    // d = days
    for (int t = 1; t <= k; t++) {
      for (int d = 1; d < len; d++) {
        int max = dp[t][d-1];
        for (int p = d-1; p >= 0 ; p--) {
          max = Math.max(max, dp[t-1][p]+stocks[d]-stocks[p]);
        }
        dp[t][d] = max;
      }
    }
    return dp[k][len-1];
  }

  private static int getMaxProfitWithKTransactionOptimized(int[] stocks, int k) {
    int len = stocks.length;
    int[][] dp = new int[k+1][len];

    // t = transaction
    // d = days
    for (int t = 1; t <= k; t++) {
      int max = dp[t-1][0] - stocks[0];
      for (int d = 1; d < len; d++) {
        dp[t][d] = Math.max(dp[t][d-1], max+stocks[d]);
        max = Math.max(max, dp[t-1][d]-stocks[d]);
      }
    }
    return dp[k][len-1];
  }
}
