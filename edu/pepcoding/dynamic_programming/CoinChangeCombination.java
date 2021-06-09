package edu.pepcoding.dynamic_programming;

import java.util.Scanner;

public class CoinChangeCombination {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-combination-official/ojquestion

  // Solution: https://www.youtube.com/watch?v=l_nR5X9VmaI&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=13
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int targetAmt = sc.nextInt();

    System.out.println(getTotalCombination(arr, targetAmt));
  }

  private static int getTotalCombination(int[] arr, int targetAmt) {
    int[] dp = new int[targetAmt+1];
    dp[0] = 1;

    for (int i = 0; i < arr.length; i++) {
      for (int j = arr[i]; j < dp.length; j++) {
        if(dp[j-arr[i]]>0){
          dp[j] += dp[j-arr[i]];
        }
      }
    }

    return dp[targetAmt];
  }
}
