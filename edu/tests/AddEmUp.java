package edu.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddEmUp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    System.out.println(N + " -> " + getAllAdders(N));
  }

  private static int getDigitSum(int i) {
    int sum = 0;
    while (i > 0) {
      sum += i % 10;
      i /= 10;
    }

    return sum;
  }

  private static List<Integer> getAllAdders(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    int p = 9 * getNumberOfDigits(n);
    for (int i = 1; i <= p; i++) {
      if (i == getDigitSum(n - i)) {
        list.add(n - i);
      }
    }
    return list;
  }

  public static int getNumberOfDigits(int n) {
    int count = 0;
    while (n > 0) {
      n /= 10;
      count++;
    }
    return count;
  }
}
