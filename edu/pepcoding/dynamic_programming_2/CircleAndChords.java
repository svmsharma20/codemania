package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/circle-and-chords-official/ojquestion
// https://youtu.be/qgQg1BcCWBA?list=TLGGhPHWqEt-HVowMTA3MjAyMQ
public class CircleAndChords {

  public static long NumberOfChords(int n){
    long[] dp = new long[n+1];
    dp[0] = 1;
    dp[1] = 1;

    for(int i = 2; i <= n; i++){
      int p = 0;
      int q = i-1;
      while(p<q){
        dp[i] += 2 * dp[p] * dp[q];
        p++;
        q--;
      }
      if(p == q){
        dp[i] += dp[p] * dp[q];
      }
    }
    return dp[n];
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(NumberOfChords(n));
  }

}
