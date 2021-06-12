package edu.pepcoding.dynamic_programming;

import java.util.Scanner;

public class PaintHouse {
  static final int RED = 0;
  static final int BLUE = 1;
  static final int GREEN = 2;

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-official/ojquestion
  // https://youtu.be/kh48JLieeW8?list=TLGGHFK0YNh65RAxMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][3];
    for (int i = 0; i < n; i++) {
      arr[i][RED] = sc.nextInt();
      arr[i][BLUE] = sc.nextInt();
      arr[i][GREEN] = sc.nextInt();
    }

    System.out.println(getPaintCost(arr));
  }

  private static int getPaintCost(int[][] arr) {
    int costToPaintRed = arr[0][RED];
    int costToPaintBlue = arr[0][BLUE];
    int costToPaintGreen = arr[0][GREEN];

    for (int i = 1; i < arr.length; i++) {
      int costToPaintIHouseWithRed = arr[i][RED] + Math.min(costToPaintBlue, costToPaintGreen);
      int costToPaintIHouseWithBlue = arr[i][BLUE] + Math.min(costToPaintRed, costToPaintGreen);
      int costToPaintIHouseWithGreen = arr[i][GREEN] + Math.min(costToPaintBlue, costToPaintRed);

      costToPaintRed = costToPaintIHouseWithRed;
      costToPaintBlue = costToPaintIHouseWithBlue;
      costToPaintGreen = costToPaintIHouseWithGreen;

    }

    return Math.min(costToPaintRed, Math.min(costToPaintBlue, costToPaintGreen));
  }
}
