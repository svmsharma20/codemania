package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class LongestPalindromicSubstring {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lpss-official/ojquestion
  // https://youtu.be/WpYHNHofwjc?list=TLGGYVqP2zpmsyoyMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();

    System.out.println(getLPS(str));
  }

  private static int getLPS(String str) {
    boolean[][] dp = new boolean[str.length()][str.length()];
    int maxLen = 0;

    for (int g = 0; g < str.length(); g++) {
      for (int i = 0, j = g; j < str.length(); i++, j++) {
        if(g==0){
          dp[i][j] = true;
          maxLen = 1;
        }else if(g==1){
          if(str.charAt(i) == str.charAt(j)){
            dp[i][j] = true;
            maxLen = 2;
          }
        }else {
          if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]){
            dp[i][j] = true;
            maxLen = Math.max(maxLen, g+1);
          }
        }
      }
    }

    return maxLen;
  }
}
