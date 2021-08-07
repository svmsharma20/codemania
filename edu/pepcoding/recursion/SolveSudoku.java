package edu.pepcoding.recursion;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/solve-sudoku-official/ojquestion
public class SolveSudoku {

  public static void display(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    if (i == board.length) {
      display(board);
      return;
    }

    int ni = 0;
    int nj = 0;

    if (j == board[0].length - 1) {
      ni = i + 1;
      nj = 0;
    } else {
      ni = i;
      nj = j + 1;
    }

    if (board[i][j] != 0) {
      solveSudoku(board, ni, nj);
    } else {
      for (int k = 1; k <= 9; k++) {
        if (isValid(board, i, j, k)) {
          board[i][j] = k;
          solveSudoku(board, ni, nj);
          board[i][j] = 0;
        }
      }
    }

  }


  public static boolean isValid(int[][] board, int row, int col, int val) {
    for (int j = 0; j < board[0].length; j++) {
      if (board[row][j] == val) {
        return false;
      }
    }

    for (int i = 0; i < board.length; i++) {
      if (board[i][col] == val) {
        return false;
      }
    }

    int matx = (row / 3) * 3;
    int maty = (col / 3) * 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[matx + i][maty + j] == val) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
