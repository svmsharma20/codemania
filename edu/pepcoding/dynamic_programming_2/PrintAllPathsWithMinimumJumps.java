package edu.pepcoding.dynamic_programming_2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrintAllPathsWithMinimumJumps {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-jumps-re-official/ojquestion
  // https://youtu.be/phgjL7SbsWs?list=TLGGtYWrTFfrvXwyNDA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    printAllPaths(arr);

    sc.close();
  }

  private static void printAllPaths(int[] arr) {
    int[] dp = new int[arr.length];

    for (int i = arr.length-2; i >=0 ; i--) {
      int min = Integer.MAX_VALUE;
      if(arr[i]==0){
        dp[i] = Integer.MAX_VALUE;
        continue;
      }
      for (int j = 1; j <= arr[i] && (j+i)<arr.length; j++) {
        min = Math.min(min, dp[i+j]);
      }
      dp[i] = min+1;
    }

    System.out.println(dp[0]);
    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(dp[0], 0, arr[0], 0+""));

    while (!queue.isEmpty()){
      Pair rem = queue.removeFirst();

      if(rem.jumps == 0){
        System.out.println(rem.psf+" .");
      }

      for (int i = rem.index+1; i <= (rem.index + rem.value) && i<arr.length; i++) {
        if(dp[i] == rem.jumps-1){
          queue.add(new Pair(dp[i], i, arr[i], rem.psf + " -> " +i));
        }
      }
    }
  }

  static class Pair{
    int jumps;
    int index;
    int value;
    String psf;   // path so far

    public Pair(int jumps, int index, int value, String psf) {
      this.jumps = jumps;
      this.index = index;
      this.value = value;
      this.psf = psf;
    }
  }
}
