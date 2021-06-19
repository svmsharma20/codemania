package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class MinCostInMazeTraversal {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/min-cost-maze-traversal-official/ojquestion
  public static void main  (String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[][] maze = new int[n][m];
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        maze[i][j] = sc.nextInt();
      }
    }

    System.out.println(getMinimunCostPath(maze));
  }

  public static int getMinimunCostPath(int[][] maze){
    int n = maze.length;
    int m = maze[0].length;
    int[][] dp = new int[n][m];
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(i==0 && j==0){
          dp[i][j] = maze[0][0];
        }else if(i==0){
          dp[i][j] = maze[i][j] + dp[i][j-1];
        }else if(j==0){
          dp[i][j] = maze[i][j] + dp[i-1][j];
        }else{
          dp[i][j] = maze[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    return dp[n-1][m-1];
  }

}
