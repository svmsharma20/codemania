package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class LongestCommonSubsequence {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lcs-official/ojquestion
  // https://www.youtube.com/watch?v=0Ql40Llp09E&list=TLGGjT4HeriEndEyMTA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    String str2 = sc.nextLine();

    System.out.println(getLCS(str1, str2));
  }

  private static int getLCS(String str1, String str2) {
    int[][] dp = new int[str1.length()+1][str2.length()+1];

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if(str1.charAt(i-1)==str2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1]+1;
        }else{
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    return dp[str1.length()][str2.length()];
  }
}
