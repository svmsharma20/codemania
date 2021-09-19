package edu.tests;

import java.util.Scanner;

public class FindNonDuplicateInArray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    printNonDuplicate(arr);
  }

  private static void printNonDuplicate(int[] arr) {
    int xor = 0;
    for (int i = 0; i < arr.length; i++) {
      xor ^= arr[i];
    }
    int n1 = 0;
    int n2 = 0;
    int k = 1;
    while ((xor & k) == 0) {
      k <<= 1;
    }

    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] & k) == 0) {
        n1 ^= arr[i];
      } else {
        n2 ^= arr[i];
      }
    }

    System.out.println("n1: " + n1 + " n2: " + n2);
  }
}
