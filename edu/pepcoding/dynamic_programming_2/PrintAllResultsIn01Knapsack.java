package edu.pepcoding.dynamic_programming_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/zero-one-knapsack-re-official/ojquestion
// https://youtu.be/YH6M9WFp02g?list=TLGGxtCA9n4b1WcyNzA2MjAyMQ

public class PrintAllResultsIn01Knapsack {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] values = new int[n];
    String str1 = br.readLine();
    for (int i = 0; i < n; i++) {
      values[i] = Integer.parseInt(str1.split(" ")[i]);
    }

    int[] wts = new int[n];
    String str2 = br.readLine();
    for (int i = 0; i < n; i++) {
      wts[i] = Integer.parseInt(str2.split(" ")[i]);
    }

    int cap = Integer.parseInt(br.readLine());

    int[][] dp = new int[n+1][cap+1];

    for(int i=1; i<=n; i++){
      for(int j=1; j<=cap; j++){
        if(j<wts[i-1]){
          dp[i][j] = dp[i-1][j];
        }else{
          dp[i][j] = Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-wts[i-1]]);
        }

      }
    }

    System.out.println(dp[n][cap]);

    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(n, cap, ""));

    while(!queue.isEmpty()){
      Pair rem = queue.removeFirst();

      if(rem.i==0 || rem.j==0){
        System.out.println(rem.psf);
      }else{
        if(dp[rem.i][rem.j] == dp[rem.i-1][rem.j]){
          queue.add(new Pair(rem.i-1, rem.j, rem.psf));
        }

        if(rem.j>=wts[rem.i-1] && dp[rem.i][rem.j] == dp[rem.i-1][rem.j-wts[rem.i-1]] + values[rem.i-1]){
          queue.add(new Pair(rem.i-1, rem.j-wts[rem.i-1], rem.i-1 + " " + rem.psf));
        }
      }
    }
  }

  static class Pair{
    int i;
    int j;
    String psf;

    Pair(int i, int j, String psf){
      this.i = i;
      this.j = j;
      this.psf = psf;
    }
  }
}
