package edu.pepcoding.dynamic_programming;

import java.util.Scanner;

public class BuyAndSellStocksWithCooldownInfiniteTransactionAllowed {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] stocks = new int[n];

    for (int i = 0; i < n; i++) {
      stocks[i] = sc.nextInt();
    }

    System.out.println(getMaxProfit(stocks));
  }

  private static int getMaxProfit(int[] stocks) {
    int bsp = -stocks[0];
    int ssp = 0;
    int csp = 0;

    for (int i = 1; i < stocks.length; i++) {
      int nbsp = Math.max(bsp, csp-stocks[i]);
      int nssp = Math.max(ssp, stocks[i] + bsp);
      int ncsp = Math.max(csp, ssp);

      bsp = nbsp;
      ssp = nssp;
      csp = ncsp;
    }

    return ssp;
  }
}
