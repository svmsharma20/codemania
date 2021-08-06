package edu.pepcoding.recursion;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-maze-paths-official/ojquestion
public class GetMazePaths {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    System.out.println(getMazePaths(1, 1, n, m));
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

    if (sr == dr && sc == dc) {
      ArrayList<String> p = new ArrayList<>();
      p.add("");
      return p;
    }

    ArrayList<String> paths = new ArrayList<>();

    if (sc < dc) {
      ArrayList<String> hPaths = getMazePaths(sr, sc + 1, dr, dc);
      for (String s : hPaths) {
        paths.add("h" + s);
      }
    }

    if (sr < dr) {
      ArrayList<String> vPaths = getMazePaths(sr + 1, sc, dr, dc);
      for (String s : vPaths) {
        paths.add("v" + s);
      }
    }

    return paths;
  }

}
