package edu.pepcoding.recursion;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/lexicographical-numbers-official/ojquestion
public class LexicographicalNumbers {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    for (int i = 1; i < 10; i++) {
      printLexNum(n, i);
    }
  }

  public static void printLexNum(int n, int num) {
    if (num > n) {
      return;
    }

    System.out.println(num);
    for (int i = 0; i < 10; i++) {
      printLexNum(n, num * 10 + i);
    }
  }

}
