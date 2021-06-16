package edu.pepcoding.array;

import java.util.Scanner;

public class BuyAndSellStocksInfiniteTransactionAllowedWithFee {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-transaction-fee-ita-official/ojquestion
  // https://youtu.be/pTQB9wbIpfU?list=TLGGKVr1x7ovhQsxNjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] stocks = new int[n];

    for (int i = 0; i < n; i++) {
      stocks[i] = sc.nextInt();
    }

    int fee = sc.nextInt();

    System.out.println(getMaxProfit(stocks, fee));
  }

  private static int getMaxProfit(int[] stocks, int fee) {
    final int BUY_STATE_PROFIT = 0;
    final int SELL_STATE_PROFIT = 1;

    int dp[][] = new int[stocks.length][2];
    dp[0][BUY_STATE_PROFIT] = stocks[0]*(-1);

    for (int i = 1; i < stocks.length; i++) {
        dp[i][BUY_STATE_PROFIT] = Math.max(dp[i-1][BUY_STATE_PROFIT], dp[i-1][SELL_STATE_PROFIT] - stocks[i]);
        dp[i][SELL_STATE_PROFIT] = Math.max(dp[i-1][SELL_STATE_PROFIT], stocks[i] + dp[i-1][BUY_STATE_PROFIT] - fee);
    }

    return dp[stocks.length-1][SELL_STATE_PROFIT];
  }
}
