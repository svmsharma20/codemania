package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class CountPalindromicSubsequences {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/cps-official/ojquestion
  // https://www.youtube.com/watch?v=YHSjvswCXC8&list=TLGGwmg3U7tS4PoyMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    System.out.println(getPSCount(str));
  }

  private static int getPSCount(String str) {
    int[][] dp = new int[str.length()][str.length()];

    for (int g = 0; g < str.length(); g++) {
      for (int i = 0, j = g; j < str.length(); i++, j++) {
        if(g==0){
          dp[i][j] = 1;
        }else if(g==1){
          if(str.charAt(i) == str.charAt(j)){
            dp[i][j] = 3;
          }else{
            dp[i][j] = 2;
          }
        }else if(str.charAt(i) == str.charAt(j)){
          dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1;
        }else{
          dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
        }
      }
    }

    return dp[0][str.length()-1];
  }
}
