package edu.pepcoding.array;

import java.util.Scanner;

public class BuyAndSellStocksTwoTransactionsAllowed {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-tta-official/ojquestion
  // https://youtu.be/wuzTpONbd-0?list=TLGGyjcZwMrklxExODA2MjAyMQ
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
    int[] maxProfitTillTodayIfSoldToday = new int[stocks.length];
    int[] maxProfitAfterTodayIfBoughtToday = new int[stocks.length];


    int lastLeastValue = stocks[0];
    int max = 0;

    for (int i = 1; i < stocks.length; i++) {
      if(stocks[i]<=lastLeastValue){
        lastLeastValue = stocks[i];
      }
      max = Math.max(max, stocks[i] - lastLeastValue);
      maxProfitTillTodayIfSoldToday[i] = max;
    }

    int lastHighestValue = stocks[stocks.length-1];
    max=0;

    for (int i = stocks.length-2; i >= 0; i--) {
      if(stocks[i]>=lastHighestValue){
        lastHighestValue = stocks[i];
      }

      max = Math.max(max, lastHighestValue - stocks[i]);
      maxProfitAfterTodayIfBoughtToday[i] = max;
    }

    max = 0;

    for (int i = 0; i < stocks.length; i++) {
      max = Math.max(max, maxProfitTillTodayIfSoldToday[i]+maxProfitAfterTodayIfBoughtToday[i]);
    }

    return max;
  }
}
