package edu.pepcoding.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathWithJumps {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(getMazePaths(1, 1, n, m));
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
    ArrayList<String> paths = new ArrayList<>();

    if (sr == dr && sc == dc) {
      paths.add("");
      return paths;
    }

    for (int i = 1; (sc + i) <= dc; i++) {
      ArrayList<String> hPaths = getMazePaths(sr, sc + i, dr, dc);
      for (String s : hPaths) {
        paths.add("h" + i + s);
      }
    }

    for (int i = 1; (sr + i) <= dr; i++) {
      ArrayList<String> vPaths = getMazePaths(sr + i, sc, dr, dc);
      for (String s : vPaths) {
        paths.add("v" + i + s);
      }
    }

    for (int i = 1; (sr + i) <= dr && (sc + i) <= dc; i++) {
      ArrayList<String> dPaths = getMazePaths(sr + i, sc + i, dr, dc);
      for (String s : dPaths) {
        paths.add("d" + i + s);
      }
    }

    return paths;
  }
}
