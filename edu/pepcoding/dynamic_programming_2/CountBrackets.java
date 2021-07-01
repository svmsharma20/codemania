package edu.pepcoding.dynamic_programming_2;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-brackets-official/ojquestion
// https://youtu.be/n-8R95-5MXw?list=TLGGRbeq73roQtUwMTA3MjAyMQ
public class CountBrackets {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;

    for(int i = 2; i <= n; i++){
      int p = 0;
      int q = i-1;

      while(p<q){
        dp[i] += 2 * dp[p] * dp[q];
        p++;
        q--;
      }

      if(p==q){
        dp[i] += dp[p] * dp[p];
      }
    }
    System.out.println(dp[n]);

    sc.close();
  }

}
