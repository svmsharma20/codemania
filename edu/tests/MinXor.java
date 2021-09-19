package edu.tests;

import java.util.Scanner;

/*
 * Given two integers A and B, find a number X such that A xor X is minimum possible and,
 * the number of set bits in X equals B.
 * */
public class MinXor {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(getMinXorWithSameBitCount(a, b));
  }

  private static int getMinXorWithSameBitCount(int a, int b) {
    if (b == 0) {
      return 0;
    }
    int aCount = getSetBitCount(a);

    if (aCount > b) {
      int num = 0;
      int pos = 0;
      int temp = a;
      while (temp > 0) {
        if ((temp & 1) == 1) {
          pos++;
        }
        temp >>= 1;
      }
      int i = 1 << (pos - 1);

      // make most significant bits one
      while (i > 0 && b > 0) {
        if ((i & a) > 0) {
          num += i;
          b--;
        }
        i >>= 1;
      }
      return num;
    } else if (b > aCount) {

      // make least significant bits one
      int diff = b - aCount;
      int num = a;
      int k = 1;
      while (diff > 0) {
        if ((a & k) == 0) {
          num += k;
          diff--;
        }
        k <<= 1;
      }
      return num;
    }

    return a;
  }

  private static int getSetBitCount(int n) {
    int count = 0;
    while (n > 0) {
      n = n & (n - 1);
      count++;
    }

    return count;
  }
}
