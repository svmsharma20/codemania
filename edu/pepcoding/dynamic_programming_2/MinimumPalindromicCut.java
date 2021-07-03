package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-palindromic-cut-official/ojquestion
// https://youtu.be/qmTtAbOTqcg?list=TLGG9fD6ZIcWlq4wMzA3MjAyMQ
public class MinimumPalindromicCut {

  // takes O(n^3) time complexity
  public static int minPalindromicCut_NonOptimized(String s) {
    int len = s.length();
    int[][] dp = new int[len][len];

    for(int g = 0; g<len; g++){
      for(int i = 0, j = g; j < len; i++, j++){
        if(g == 0){
          dp[i][j] = 0;
        }else if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 0){
          dp[i][j] = 0;
        }else{
          int p = i;
          int q = i+1;
          int min = Integer.MAX_VALUE;
          while(p<j && q<=j){
            min = Math.min(min, dp[i][p]+dp[q][j]);
            p++;
            q++;
          }
          dp[i][j] = min+1;
        }
      }
    }

    return dp[0][len-1];
  }

  // takes O(n^2) time complexity
  public static int minPalindromicCut(String s) {
    int len = s.length();
    boolean[][] dp = new boolean[len][len];

    for(int g = 0; g<len; g++){
      for(int i = 0, j = g; j < len; i++, j++){
        if(g == 0){
          dp[i][j] = true;
        } else if (g == 1){
          dp[i][j] =   (s.charAt(i) == s.charAt(j));
        }else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
          dp[i][j] = true;
        }
      }
    }


    int[] strg = new int[len];
    strg[0] = 0;

    for( int j = 1; j < len; j++){
      if(dp[0][j]){
        strg[j] = 0;
      }else{
        int min = Integer.MAX_VALUE;
        for(int i = j; i > 0; i--){
          if(dp[i][j]){
            min = Math.min(min, strg[i-1]);
          }
        }
        strg[j] = min + 1;
      }
    }

    return strg[len-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    System.out.println(minPalindromicCut(str));
  }
}
