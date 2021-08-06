package edu.pepcoding.recursion;

import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-permutations-official/ojquestion
public class PrintPermutations {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();

    printPermutations(str, "");
  }

  public static void printPermutations(String str, String asf) {

    if (str.length() == 0) {
      System.out.println(asf);
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      String sub = str.substring(0, i) + str.substring(i + 1);
      printPermutations(sub, asf + ch);
    }
  }

}
