package edu.pepcoding.recursion;

import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/flood-fill-official/ojquestion
public class FloodFill {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    floodfill(arr, 0, 0, "");
  }

  // asf -> answer so far
  public static void floodfill(int[][] maze, int sr, int sc, String asf) {
    int n = maze.length;
    int m = maze[0].length;

    if (sr == n - 1 && sc == m - 1) {
      System.out.println(asf);
      return;
    }

    // for top
    if (sr > 0 && maze[sr - 1][sc] != 1) {
      int[][] tmaze = new int[n][m];
      for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[0].length; j++) {
          tmaze[i][j] = maze[i][j];
        }
      }
      tmaze[sr - 1][sc] = 1;
      floodfill(tmaze, sr - 1, sc, asf + "t");
    }

    // for left
    if (sc > 0 && maze[sr][sc - 1] != 1) {
      int[][] lmaze = new int[n][m];
      for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[0].length; j++) {
          lmaze[i][j] = maze[i][j];
        }
      }
      lmaze[sr][sc - 1] = 1;
      floodfill(lmaze, sr, sc - 1, asf + "l");
    }

    // for down
    if (sr < n - 1 && maze[sr + 1][sc] != 1) {
      int[][] dmaze = new int[n][m];
      for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[0].length; j++) {
          dmaze[i][j] = maze[i][j];
        }
      }
      dmaze[sr + 1][sc] = 1;
      floodfill(dmaze, sr + 1, sc, asf + "d");
    }

    // for right
    if (sc < m - 1 && maze[sr][sc + 1] != 1) {
      int[][] rmaze = new int[n][m];
      for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[0].length; j++) {
          rmaze[i][j] = maze[i][j];
        }
      }
      rmaze[sr][sc + 1] = 1;
      floodfill(rmaze, sr, sc + 1, asf + "r");
    }
  }
}
