package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class Goldmine {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/goldmine-official/ojquestion
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[][] goldmine = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        goldmine[i][j] = sc.nextInt();
      }
    }

    System.out.println(getMaxGold(goldmine));
  }

  private static int getMaxGold(int[][] goldmine) {
    int n = goldmine.length;
    int m = goldmine[0].length;

    int[][] dp = new int[n][m];

    // column wise traversal from right
    for (int col = m-1; col >= 0; col--) {
      for (int row = 0; row < n; row++) {
        if(col==m-1){
          dp[row][col] = goldmine[row][col];
        }else if(row==0){
          dp[row][col] += goldmine[row][col] + Math.max(dp[row][col+1], dp[row+1][col+1]);
        }else if(row==n){
          dp[row][col] += goldmine[row][col] + Math.max(dp[row][col+1], dp[row-1][col+1]);
        }else{
          dp[row][col] += goldmine[row][col] + Math.max(dp[row][col+1], Math.max(dp[row-1][col+1], dp[row+1][col+1]));
        }
      }
    }
    int max = Integer.MIN_VALUE;

    for (int row = 0; row < n; row++) {
      max = Math.max(max, dp[row][0]);
    }

    return max;
  }
}
