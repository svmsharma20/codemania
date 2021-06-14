package edu.pepcoding.array;

import java.util.Scanner;

public class BuyAndSellStocksOneTransactionAllowed {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ota-official/ojquestion#!
  // https://youtu.be/4YjEHmw1MX0?list=TLGGjlTIYUqp48UxNDA2MjAyMQ
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
    int lastLeastValue = stocks[0];

    for (int i = 1; i < stocks.length; i++) {
      if(stocks[i] <= lastLeastValue){
        lastLeastValue = stocks[i];
      }else{
        maxProfit = Math.max(maxProfit, stocks[i]-lastLeastValue);
      }
    }

    return maxProfit;
  }
}
