package edu.pepcoding.dynamic_programming;

import java.util.Scanner;

public class CoinChangePermutations {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-permutations-official/ojquestion

  // https://www.youtube.com/watch?v=yc0LunmJA1A&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=14
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int targetAmt = sc.nextInt();

    System.out.println(getTotalPermutation(arr, targetAmt));
  }

  private static int getTotalPermutation(int[] coins, int targetAmt) {
    int[] dp = new int[targetAmt+1];
    dp[0] = 1;

    for (int amt = 1; amt < dp.length; amt++) {
      for (int coin :  coins) {
        if(coin<=amt){
          dp[amt] += dp[amt-coin];
        }
      }
    }

    return dp[targetAmt];
  }
}
