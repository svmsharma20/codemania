package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lis-official/ojquestion
  // https://youtu.be/odrfUCS9sQk?list=TLGGavYdLd4kkPsxOTA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(getLIS(arr));
  }

  private static int getLIS(int[] arr) {
    int dp[] = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      int max = 0;
      for (int j = i-1; j >= 0; j--) {
          if(arr[j]<arr[i]){
            max = Math.max(max, dp[j]);
          }
      }
      dp[i] = max+1;
    }

    int maxLen = dp[0];

    for (int i = 1; i < dp.length; i++) {
      maxLen = Math.max(maxLen, dp[i]);
    }

    return maxLen;
  }
}
