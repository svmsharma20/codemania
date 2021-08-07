package edu.pepcoding.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GoldMine2 {

  static int max = 0;

  public static void getMaxGold(int[][] arr) {
    boolean[][] visited = new boolean[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] != 0 && !visited[i][j]) {
          ArrayList<Integer> bag = new ArrayList<>();
          collectAndTraverse(arr, visited, i, j, bag);
          int sum = 0;
          for (int val : bag) {
            sum += val;
          }

          max = Math.max(max, sum);
        }
      }
    }

  }

  public static void collectAndTraverse(int[][] arr, boolean[][] visited, int i, int j,
      ArrayList<Integer> bag) {
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0
        || visited[i][j]) {
      return;
    }

    visited[i][j] = true;
    bag.add(arr[i][j]);
    collectAndTraverse(arr, visited, i - 1, j, bag);
    collectAndTraverse(arr, visited, i + 1, j, bag);
    collectAndTraverse(arr, visited, i, j - 1, bag);
    collectAndTraverse(arr, visited, i, j + 1, bag);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] arr = new int[m][n];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    getMaxGold(arr);
    System.out.println(max);
  }
}
