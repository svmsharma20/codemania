package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/regular-expression-matching-official/ojquestion
// https://youtu.be/DJvw8jCmxUU?list=TLGGazh8tGf66O4wMTA3MjAyMQ
public class RegularExpressionMatching {

  public static boolean solution(String s, String p) {
    char[] sArr = s.toCharArray();
    char[] pArr = p.toCharArray();

    boolean[][] dp = new boolean[pArr.length+1][sArr.length+1];

    for(int i=0; i<dp.length; i++){
      for(int j=0; j<dp[0].length; j++){
        if(i==0 && j==0){
          dp[i][j] = true;
        }else if(i==0){
          dp[i][j] = false;
        }else if(j==0){
          if(pArr[i-1]=='*'){
            dp[i][j] = dp[i-2][j];
          }else{
            dp[i][j] = false;
          }
        }else{
          if(pArr[i-1] == '*'){
            dp[i][j] = dp[i-2][j] || ((pArr[i-2] == sArr[j-1] || pArr[i-2] == '.') && dp[i][j-1]);
          }else if(pArr[i-1] == '.'){
            dp[i][j] = dp[i-1][j-1];
          }else {
            dp[i][j] = (pArr[i-1] == sArr[j-1]) && dp[i-1][j-1];
          }
        }
      }
    }

    return dp[pArr.length][sArr.length];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.next();
    String s2 = scn.next();
    System.out.println(solution(s1,s2));
  }

}
