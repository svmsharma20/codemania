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
    int bsp = -stocks[0];
    int ssp = 0;

    for (int i = 1; i < stocks.length; i++) {
        int nbsp = Math.max(bsp, ssp - stocks[i]);
        int nssp = Math.max(ssp, stocks[i] + bsp - fee);
        bsp = nbsp;
        ssp = nssp;
    }

    return ssp;
  }
}
