package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class UnboundedKnapsack {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/unbounded-knapsack-official/ojquestion
  // https://www.youtube.com/watch?v=jgps7MXtKRQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=17
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] values = new int[n];
    int[] weight = new int[n];

    for (int i = 0; i < n; i++) {
      values[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      weight[i] = sc.nextInt();
    }

    int capacity = sc.nextInt();

    System.out.println(getMaxProfit(values, weight, capacity));
  }

  private static int getMaxProfit(int[] values, int[] weight, int maxCapacity) {
    int size = values.length;
    int[] dp = new int[maxCapacity+1];

    for (int capacity = 1; capacity < dp.length; capacity++) {
      int max = 0;
      for (int itemIndex = 0; itemIndex < values.length; itemIndex++) {
        if(weight[itemIndex]<=capacity){
          max = Math.max(max, values[itemIndex] + dp[capacity - weight[itemIndex]]);
        }
      }
      dp[capacity] = max;
    }

    return dp[maxCapacity];
  }
}
