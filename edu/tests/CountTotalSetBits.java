package edu.tests;

import java.util.Scanner;

public class CountTotalSetBits {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(getCountOfSetBitsWithoutMathLib(n));
  }

  private static int getCountOfSetBits(int n) {
    int count = 0;
    while (n > 0) {
      int log2 = logBase2(n);
      n -= Math.pow(2, log2);
      count++;
    }

    return count;
  }

  private static int logBase2(int n) {
    return (int) (Math.log(n) / Math.log(2));
  }

  private static int getCountOfSetBitsWithoutMathLib(int n) {
    int count = 0;
    while (n > 0) {
      count++;
      n = n & (n - 1);
    }

    return count;
  }

}
