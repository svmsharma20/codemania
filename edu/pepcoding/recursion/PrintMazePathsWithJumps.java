package edu.pepcoding.recursion;

import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-maze-path-with-jumps-official/ojquestion
public class PrintMazePathsWithJumps {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    printMazePaths(1, 1, n, m, "");
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
    if (sr == dr && sc == dc) {
      System.out.println(psf);
      return;
    }

    for (int i = 1; (sc + i) <= dc; i++) {
      printMazePaths(sr, sc + i, dr, dc, psf + "h" + i);
    }

    for (int i = 1; (sr + i) <= dr; i++) {
      printMazePaths(sr + i, sc, dr, dc, psf + "v" + i);
    }

    for (int i = 1; (sr + i) <= dr && (sc + i) <= dc; i++) {
      printMazePaths(sr + i, sc + i, dr, dc, psf + "d" + i);
    }
  }

}
