package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

public class CatalanNumber {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/catalan-number-official/ojquestion
  // https://www.youtube.com/watch?v=eUw9A1wsFg8&list=TLGG1B5wtT4FdEgwMTA3MjAyMQ
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;

    for(int i=2; i<=n; i++){
      int p=0;
      int q = i-1;

      while(p<=q){
        dp[i] += (p!=q) ? (2 * dp[p]*dp[q]) : (dp[p]*dp[p]);
        p++;
        q--;
      }
    }

    System.out.println(dp[n]);
  }
}
