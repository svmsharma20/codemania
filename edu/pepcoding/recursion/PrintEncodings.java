package edu.pepcoding.recursion;

import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-encodings-official/ojquestion
public class PrintEncodings {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    printEncodings(str, "");
  }

  public static void printEncodings(String str, String ans) {

    if (str.length() == 0) {
      System.out.println(ans);
      return;
    }

    char ch = str.charAt(0);
    int n1 = Integer.parseInt(ch + "");
    String sub = str.substring(1);
    if (n1 > 0) {
      printEncodings(sub, ans + ((char) ('a' + n1 - 1) + ""));
    }

    if (sub.length() > 0 && n1 != 0) {
      char ch2 = sub.charAt(0);
      int n2 = n1 * 10 + Integer.parseInt(ch2 + "");
      String sub2 = sub.substring(1);
      if (n2 > 0 && n2 <= 26) {
        printEncodings(sub2, ans + ((char) ('a' + n2 - 1) + ""));
      }
    }
  }
}
