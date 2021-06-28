package edu.pepcoding.dynamic_programming_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/print-all-paths-with-target-sum-subset-official/ojquestion
// https://youtu.be/qtqMTgmDpQg?list=TLGGtX7mGU4CB-cyODA2MjAyMQ
public class PrintAllPathsWithTargetSumSubset {

  public static class Pair{
    int i;
    int j;
    String psf;

    public Pair(int i, int j, String psf){
      this.i = i;
      this.j = j;
      this.psf = psf;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int tar = Integer.parseInt(br.readLine());

    boolean[][] dp = new boolean[n+1][tar+1];

    for(int i=0; i<=n; i++){
      for(int j=0; j<=tar; j++){
        if(j==0){
          dp[i][j] = true;
        }else if(i==0){
          dp[i][j] = false;
        }else{
          if(j<arr[i-1]){
            dp[i][j] = dp[i-1][j];
          }else{
            dp[i][j] = (dp[i-1][j] || dp[i-1][j-arr[i-1]]);
          }
        }
      }
    }

    System.out.println(dp[n][tar]);

    ArrayDeque<Pair> queue = new ArrayDeque<>();
    if(dp[n][tar]){
      queue.add(new Pair(n, tar, ""));
    }

    while(!queue.isEmpty()){
      Pair rem = queue.removeFirst();

      if(rem.i==0 || rem.j==0){
        System.out.println(rem.psf);
      }else{
        if(rem.j>= arr[rem.i-1] && dp[rem.i-1][rem.j - arr[rem.i-1]]){
          queue.add(new Pair(rem.i-1, rem.j - arr[rem.i-1], rem.i-1 + " " + rem.psf));
        }

        if(dp[rem.i-1][rem.j]){
          queue.add(new Pair(rem.i-1, rem.j, rem.psf));
        }

      }
    }
  }
}
