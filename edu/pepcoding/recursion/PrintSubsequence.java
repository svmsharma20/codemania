package edu.pepcoding.recursion;

import java.util.Scanner;

public class PrintSubsequence {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    printSS(str, "");
  }

  public static void printSS(String str, String ans) {
    if (str.length() == 0) {
      System.out.println(ans);
      return;
    }

    char ch = str.charAt(0);
    String sub = str.substring(1);
    printSS(sub, ans + ch);
    printSS(sub, ans);
  }
}
