package edu.pepcoding.recursion;

import java.util.Scanner;

public class PrintKpc {

  private static String[] arr = new String[10];

  public static void main(String[] args) throws Exception {
    arr[0] = ".;";
    arr[1] = "abc";
    arr[2] = "def";
    arr[3] = "ghi";
    arr[4] = "jkl";
    arr[5] = "mno";
    arr[6] = "pqrs";
    arr[7] = "tu";
    arr[8] = "vwx";
    arr[9] = "yz";

    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    printKPC(str, "");
  }

  public static void printKPC(String str, String ans) {
    if (str.length() == 0) {
      System.out.println(ans);
      return;
    }
    int n = Integer.parseInt(str.charAt(0) + "");
    String numStr = arr[n];
    String sub = str.substring(1);

    for (int i = 0; i < numStr.length(); i++) {
      char ch = numStr.charAt(i);
      printKPC(sub, ans + ch);
    }
  }

}
