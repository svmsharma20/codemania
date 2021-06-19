package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class PartitionIntoSubsets {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/partition-into-subsets-official/ojquestion
  // https://youtu.be/IiAsqfjhZnY?list=TLGGl6zY9PhewQkxMjA2MjAyMQ

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(partitionKSubset(n, k));
  }

  private static long partitionKSubset(int n, int k) {
    // n,j => number of players
    // k,i => number of teams in which player needs to get divide
    long[][] dp = new long[k+1][n+1];

    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= n; j++) {
        if(j<i){
          // number of players are less than number of teams
          dp[i][j] = 0;
        }else if(j==i){
          // number of players are equal to number of teams
          dp[i][j] = 1;
        }else{
          // number of players are more than number of teams
          dp[i][j] = i*dp[i][j-1] + dp[i-1][j-1];
        }
      }
    }

    return dp[k][n];
  }
}
