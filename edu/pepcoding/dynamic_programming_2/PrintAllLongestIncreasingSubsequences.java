package edu.pepcoding.dynamic_programming_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class PrintAllLongestIncreasingSubsequences {

  public static class Pair {
    int l;
    int i;
    int v;
    String psf;

    Pair(int l, int i, int v, String psf){
      this.l = l;
      this.i = i;
      this.v = v;
      this.psf = psf;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    printLIS(arr);
  }

  private static void printLIS(int[] arr) {
    int[] dp = new int[arr.length];
    int omax = 0;
    int omi = 0;

    for (int i = 0; i < arr.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if(arr[j]<=arr[i]){
          max = Math.max(max, dp[j]);
        }
      }
      dp[i] = max+1;
      if(omax<=dp[i]){
        omax = dp[i];
        omi = i;
      }
    }

    System.out.println(omax);
    ArrayDeque<Pair> queue = new ArrayDeque<>();
    for (int i = 0; i < arr.length; i++) {
      if(dp[i] == omax){
        queue.add(new Pair(dp[i], i, arr[i], ""+arr[i]));
      }
    }

    while (!queue.isEmpty()){
      Pair rem = queue.removeFirst();

      if(rem.l == 1){
        System.out.println(rem.psf);
      }

      for (int j = rem.i-1; j >= 0; j--) {
        if(dp[j] == rem.l-1 && arr[j] <= rem.v){
          queue.add(new Pair(dp[j], j, arr[j],  arr[j] + " -> "+ rem.psf));
        }
      }

    }
  }
}
