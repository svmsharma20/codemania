package edu.pepcoding.dynamic_programming_2;

import java.util.ArrayDeque;
import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/goldmine-re-official/ojquestion
// https://youtu.be/mme6Tqj8tyY?list=TLGGxxABjrcDaqUyODA2MjAyMQ
public class PrintAllPathsWithMaximumGold {

  private static class Pair {
    String psf;
    int row;
    int col;

    public Pair(int row, int col, String psf) {
      this.psf = psf;
      this.row = row;
      this.col = col;
    }

  }
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    printAllPaths(arr);
  }


  private static void printAllPaths(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;

    int[][] dp = new int[n][m];
    int omax = 0;

    for (int j = m - 1; j >= 0 ; j--) {
      for (int i = 0; i < n ; i++) {
        if (j == m - 1) {
          dp[i][j] = arr[i][j];
        } else if (i == 0) {
          dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + arr[i][j];
        } else if (i == n - 1) {
          dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + arr[i][j];
        } else {
          dp[i][j] = Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1])) + arr[i][j];
        }

        omax = Math.max(omax, dp[i][j]);
      }
    }

    System.out.println(omax);

    ArrayDeque<Pair> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (dp[i][0] == omax) {
        queue.add(new Pair( i, 0,  i + "" ));
      }
    }

    while (!queue.isEmpty()) {
      Pair rem = queue.removeFirst();

      if (rem.col == arr[0].length - 1) {
        System.out.println(rem.psf);
      } else {

        if(rem.row == 0){
          int max = Math.max( dp[rem.row][rem.col+1], dp[rem.row+1][rem.col+1]);

          if(dp[rem.row][rem.col+1] == max){
            queue.add(new Pair(rem.row, rem.col+1, rem.psf+" d2"));
          }

          if(dp[rem.row+1][rem.col+1] == max){
            queue.add(new Pair(rem.row+1, rem.col+1,rem.psf+ " d3"));
          }
        }else if (rem.row == arr.length - 1){

          int max = Math.max(dp[rem.row-1][rem.col+1], dp[rem.row][rem.col+1]);

          if(dp[rem.row-1][rem.col+1] == max){
            queue.add(new Pair(rem.row-1, rem.col+1, rem.psf+" d1"));
          }

          if(dp[rem.row][rem.col+1] == max){
            queue.add(new Pair( rem.row, rem.col+1, rem.psf+" d2"));
          }

        }else{
          int max = Math.max(dp[rem.row-1][rem.col+1], Math.max(dp[rem.row][rem.col+1], dp[rem.row+1][rem.col+1]));

          if(dp[rem.row-1][rem.col+1] == max){
            queue.add(new Pair( rem.row-1, rem.col+1, rem.psf+" d1"));
          }

          if(dp[rem.row][rem.col+1] == max){
            queue.add(new Pair( rem.row, rem.col+1, rem.psf+" d2"));
          }

          if(dp[rem.row+1][rem.col+1] == max){
            queue.add(new Pair( rem.row+1, rem.col+1, rem.psf+" d3"));
          }
        }

      }
    }


  }

}