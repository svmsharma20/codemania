package edu.pepcoding.recursion;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-subsequence-official/ojquestion
public class GetSubsequence {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(gss(str));
  }

  public static ArrayList<String> gss(String str) {
    if (str.length() == 0) {
      ArrayList<String> l = new ArrayList<>();
      l.add("");
      return l;
    }
    char ch = str.charAt(0);
    String sub = str.substring(1);
    ArrayList<String> res = gss(sub);
    ArrayList<String> myres = new ArrayList<>();

    for (String s : res) {
      myres.add(s);
    }

    for (String s : res) {
      myres.add(ch + s);
    }

    return myres;
  }
}
