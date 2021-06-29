package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class WildcardPatternMatching {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/wildcard-pattern-matching-official/ojquestion
  // https://www.youtube.com/watch?v=NbgUZAoIz3g&list=TLGGHiCMM5DUt8syOTA2MjAyMQ
  public static boolean solution(String str, String pattern) {

    int pLen = pattern.length();
    int sLen = str.length();

    boolean[][] dp = new boolean[pLen+1][sLen+1];
    char[] strArr = str.toCharArray();
    char[] patternArr = pattern.toCharArray();

    for(int i=pLen; i>=0; i--){
      for(int j=sLen; j>=0; j--){
        if(i==pLen && j==sLen){
          dp[i][j] = true;
        }else if(i == pLen || j == sLen){
          dp[i][j] = false;
        }else if(patternArr[i] == '?'){
          dp[i][j] = dp[i+1][j+1];
        }else if(patternArr[i] == '*'){
          dp[i][j] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j+1];
        }else{
          dp[i][j] = (patternArr[i] == strArr[j]) && dp[i+1][j+1];
        }
      }
    }

    return dp[0][0];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.next();
    String s2 = scn.next();
    System.out.println(solution(s1,s2));
  }
}
