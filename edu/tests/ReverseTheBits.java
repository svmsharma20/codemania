package edu.tests;

import java.util.Scanner;

public class ReverseTheBits {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long a = sc.nextLong();
//    printBits(2684354560l);
    System.out.println(reverseBits(a));
  }

  private static long reverseBits(long a) {
    long num = 0l;
    long i = 1l;
    int count = 0;
    while (count < 32) {
      num <<= 1;
      if ((a & i) != 0) {
        num += 1;
      }
      i <<= 1;
      count++;
    }
    return num;
  }

  private static void printBits(int a) {
    long i = 1l << 31;
    String str = "";
    while (i > 0) {
      str += ((a & i) != 0) ? "1" : "0";
      i >>= 1;
    }
    System.out.println(str);
  }
}
