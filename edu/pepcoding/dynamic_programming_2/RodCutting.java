package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/rod-cutting-official/ojquestion
// https://www.youtube.com/watch?v=eQuJb5gBkkc&list=TLGG9rwBw-xx45kwMjA3MjAyMQ&t=191s
public class RodCutting {

  public static int solution(int[] prices) {
    int[] dp = new int[prices.length];

    for(int i = 0; i < prices.length; i++){
      int maxPrice = prices[i];
      int left = 0;
      int right = i-1;

      while(left <= right){
        maxPrice = Math.max(maxPrice, dp[left] + dp[right]);
        left++;
        right--;
      }
      dp[i] = maxPrice;
    }

    return dp[prices.length - 1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = scn.nextInt();
    }
    System.out.println(solution(prices));
  }
}
