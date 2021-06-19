package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class ClimbStairsWithMinimumMoves {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-minimum-moves-official/ojquestion
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i] = sc.nextInt();
    }

    System.out.println(getMinJump(n, arr));

  }

  public static int getMinJump(int n, int[] arr){
    int[] dp = new int[n+1];
    dp[n] = 0;

    for(int i=n-1; i>=0; i--){
      int minJumpForI = Integer.MAX_VALUE;
      for(int j=1; j<=arr[i] && (i+j)<dp.length; j++){
        minJumpForI = Math.min(minJumpForI, dp[i+j]);
      }

      dp[i] = minJumpForI==Integer.MAX_VALUE? Integer.MAX_VALUE : minJumpForI+1;
    }

    return dp[0];
  }

}
