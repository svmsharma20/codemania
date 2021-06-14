package edu.pepcoding.array;

import java.util.Scanner;

public class BuyAndSellStocksInfiniteTransactionAllowed {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ita-official/ojquestion
  // https://youtu.be/HWJ9kIPpzXs?list=TLGG5McxKxkllWsxNDA2MjAyMQ
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
    int maxProfit = 0;
    int len = stocks.length;

    for (int i = 1; i < len; i++) {
      if(stocks[i-1] < stocks[i]){
        maxProfit += stocks[i] - stocks[i-1];
      }
    }

    return maxProfit;
  }
}
