package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class CountPalindromicSubstrings {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/cpss-official/ojquestion
  // https://youtu.be/XmSOWnL6T_I?list=TLGGIyoAmAB9SesyMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();

    System.out.println(getCount(str));
  }

  private static int getCount(String str) {
    int count=0;
    boolean[][] dp = new boolean[str.length()][str.length()];

    for (int g = 0; g < str.length(); g++) {
      for (int i = 0, j = g; j < str.length(); i++, j++) {
        if(g==0){
          dp[i][j] = true;
          count++;
        }else if(g==1){
          if(str.charAt(i) == str.charAt(j)){
            dp[i][j] = true;
            count++;
          }
        }else if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1]){
          dp[i][j] = true;
          count++;
        }
      }
    }

    return count;
  }
}
