package edu.pepcoding.recursion;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-stair-paths-official/ojquestion
public class GetStairPaths {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(getStairPaths(n));
  }

  public static ArrayList<String> getStairPaths(int n) {

    if (n == 0) {
      ArrayList<String> p = new ArrayList<>();
      p.add("");
      return p;
    }

    ArrayList<String> paths = new ArrayList<>();

    if (n >= 1) {
      ArrayList<String> onePaths = getStairPaths(n - 1);

      for (String s : onePaths) {
        paths.add("1" + s);
      }
    }

    if (n >= 2) {
      ArrayList<String> twoPaths = getStairPaths(n - 2);

      for (String s : twoPaths) {
        paths.add("2" + s);
      }
    }

    if (n >= 3) {
      ArrayList<String> threePaths = getStairPaths(n - 3);

      for (String s : threePaths) {
        paths.add("3" + s);
      }
    }

    return paths;
  }

}
