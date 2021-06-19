package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class FriendsPairing {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/friends-pairing-official/ojquestion
  // https://youtu.be/SHDu0Ufjyk8?list=TLGGzkehcy5Ob1ExMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] dp = new int[n+1];
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i-1] + (i-1)*dp[i-2];
    }

    System.out.println(dp[n]);
  }
}
