package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/matrix-chain-multiplication-official/ojquestion
// https://youtu.be/pEYwLmGJcvs?list=TLGGU3WiV3bXWiswMzA3MjAyMQ
public class MatrixChainMultiplication {
  public static int mcm(int[] arr){
    int[][] dp = new int[arr.length-1][arr.length-1];

    for(int g = 1; g < dp.length; g++){
      for(int i = 0, j = g; j < dp.length; i++, j++){

        if(g == 1){
          dp[i][j] = arr[i] * arr[j] * arr[j+1];
        }else{
          int min = Integer.MAX_VALUE;
          for(int k = i; k < j; k++){
            int left = dp[i][k];
            int right = dp[k+1][j];
            int mult = arr[i] * arr[k + 1] * arr[j+1];
            int total = left + right + mult;

            min = Math.min(min, total);
          }
          dp[i][j] = min;
        }
      }
    }

    return dp[0][dp.length-1];
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    System.out.println(mcm(arr));
  }
}
