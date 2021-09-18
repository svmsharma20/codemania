package edu.tests;

import java.util.Scanner;

public class ShaktimanEatingChoclate {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(solve(n, 1, 1, 1));
  }

  public static int solve(int n, int lastDayChoclate, int currentSum, int count) {
    if (currentSum == n && (lastDayChoclate == 1)) {
      return count;
    }
    if (currentSum >= n || lastDayChoclate <= 0) {
      return -1;
    }

    int res = solve(n, lastDayChoclate + 1, (currentSum + lastDayChoclate + 1), count + 1);
    if (res != -1) {
      return res;
    }
    res = solve(n, lastDayChoclate, (currentSum + lastDayChoclate), count + 1);
    if (res != -1) {
      return res;
    }

    if (lastDayChoclate > 0) {
      res = solve(n, lastDayChoclate - 1, (currentSum + lastDayChoclate - 1), count + 1);
    }

    return res;
  }
}
