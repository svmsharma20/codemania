package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class PaintHouseManyColors {
  static final int RED = 0;
  static final int BLUE = 1;
  static final int GREEN = 2;

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-many-colors-official/ojquestion
  // https://youtu.be/jGywRalvoRw?list=TLGG7J76MVbzhHIxMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int noOfHouses = sc.nextInt();
    int noOfColors = sc.nextInt();
    int[][] arr = new int[noOfHouses][noOfColors];
    for (int i = 0; i < noOfHouses; i++) {
      for (int j = 0; j < noOfColors; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    System.out.println(getPaintCost(arr));
  }

  private static int getPaintCost(int[][] arr) {
    int minCost = Integer.MAX_VALUE;
    int minIndex = 0;
    int nextToMinCost = Integer.MAX_VALUE;
    int nextMinIndex = 0;

    for (int i = 0; i < arr[0].length; i++) {
      if(arr[0][i]<minCost){
        nextToMinCost = minCost;
        nextMinIndex = minIndex;
        minCost = arr[0][i];
        minIndex = i;
      }else if(arr[0][i]<nextToMinCost){
        nextToMinCost = arr[0][i];
        nextMinIndex = i;
      }
    }

    for (int i = 1; i < arr.length; i++) {
      int currentMincost = Integer.MAX_VALUE;
      int currentMinIndex = 0;
      int nextToCurrentMinCost = Integer.MAX_VALUE;
      int nextToCurrentMinIndex = nextMinIndex;

      for (int j = 0; j < arr[i].length; j++) {
        int cost = 0;
        if(j==minIndex){
          cost = nextToMinCost + arr[i][j];
        }else{
          cost = minCost + arr[i][j];
        }
        if(cost<currentMincost){
          nextToCurrentMinCost = currentMincost;
          nextToCurrentMinIndex = currentMinIndex;
          currentMincost = cost;
          currentMinIndex = j;
        }else if(cost<nextToCurrentMinCost){
          nextToCurrentMinCost = cost;
          nextToCurrentMinIndex = j;
        }
      }

      minCost = currentMincost;
      minIndex = currentMinIndex;
      nextToMinCost = nextToCurrentMinCost;
      nextMinIndex = nextToCurrentMinIndex;
    }
    return minCost;
  }
}
