package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/burst-balloons-official/ojquestion
// https://www.youtube.com/watch?v=YzvF8CqPafI&list=TLGGf2yrXagWJ5EwNjA3MjAyMQ
public class BurstBalloons {

  public static int solution(int[] arr) {
    int len = arr.length;
    int[][] dp = new int[len][len];

    for(int g = 0; g < len; g++){
      for(int i = 0, j=g; j < len; i++, j++){
        int maxCoins = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
          int left = (k==i) ? 0 : dp[i][k-1];
          int right = (k==j) ? 0 : dp[k+1][j];
          int leftValue = (i==0) ? 1 : arr[i-1];
          int rightValue = (j==(len-1)) ? 1 : arr[j+1];

          int coins = left + right + (leftValue * arr[k] * rightValue);
          maxCoins = Math.max(maxCoins, coins);
        }
        dp[i][j] = maxCoins;
      }
    }

    return dp[0][len-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }
}
