package edu.pepcoding.dynamic_programming_2;

import java.util.ArrayDeque;
import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/minimum-cost-path-re-official/ojquestion
// https://youtu.be/f8Vdifn2YjQ?list=TLGGtVilyacKd-UyODA2MjAyMQ
public class PrintAllPathsWithMinimumCost {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    printAllMinPaths(arr);

    sc.close();
  }

  private static void printAllMinPaths(int[][] arr) {
    int[][] dp  = new int[arr.length][arr[0].length];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if(i==0 && j==0){
          dp[i][j] = arr[i][j];
        }else if(i==0){
          dp[i][j] = dp[i][j-1] + arr[i][j];
        }else if (j==0){
          dp[i][j] = dp[i-1][j] + arr[i][j];
        }else{
          dp[i][j] = arr[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
        }
      }
    }

    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(dp[arr.length-1][arr[0].length-1], arr.length-1, arr[0].length-1, ""));

    while(!queue.isEmpty()){
      Pair rem = queue.removeFirst();

      if(rem.row == 0 && rem.col == 0){
        System.out.println(rem.psf);
        continue;
      }

      if(rem.row == 0){
        queue.add(new Pair(dp[rem.row][rem.col-1], rem.row, rem.col-1, "H"+rem.psf));
      }else if (rem.col == 0){
        queue.add(new Pair(dp[rem.row-1][rem.col], rem.row-1, rem.col, "V"+rem.psf));
      }else if(dp[rem.row][rem.col-1] < dp[rem.row-1][rem.col]){
        queue.add(new Pair(dp[rem.row][rem.col-1], rem.row, rem.col-1, "H"+rem.psf));
      }else if(dp[rem.row][rem.col-1] > dp[rem.row-1][rem.col]){
        queue.add(new Pair(dp[rem.row-1][rem.col], rem.row-1, rem.col, "V"+rem.psf));
      }else{
        queue.add(new Pair(dp[rem.row][rem.col-1], rem.row, rem.col-1, "H"+rem.psf));
        queue.add(new Pair(dp[rem.row-1][rem.col], rem.row-1, rem.col, "V"+rem.psf));
      }
    }
  }

  private static class Pair{
    int cost;
    int row;
    int col;
    String psf;

    public Pair(int cost, int row, int col, String psf) {
      this.cost = cost;
      this.row = row;
      this.col = col;
      this.psf = psf;
    }
  }
}
