package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class LongestPalindromicSubsequences {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lps-official/ojquestion
  // https://www.youtube.com/watch?v=RiNzHfoA2Lo&list=TLGGENWiHT8yESIyMjA2MjAyMQ
  // Gap strategy: https://www.youtube.com/watch?v=lvRdFCMD_Ew
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str1 = sc.nextLine();

    System.out.println(getLPS(str1));
  }

  private static int getLPS(String str1) {
    int[][] dp = new int[str1.length()][str1.length()];

    for (int g = 0; g < str1.length(); g++) {
      for (int i = 0, j = g; j < str1.length(); i++, j++) {
        if(g == 0){
          dp[i][j] = 1;
        }else{
          if(str1.charAt(i) == str1.charAt(j)){
            dp[i][j] = dp[i+1][j-1] + 2;
          }else{
            dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
          }
        }
      }
    }

    return dp[0][str1.length()-1];
  }
}
