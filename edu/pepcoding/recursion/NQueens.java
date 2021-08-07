package edu.pepcoding.recursion;

import java.util.Scanner;

// https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/n-queens-official/ojquestion
public class NQueens {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[][] chess = new int[n][n];

    printNQueens(chess, "", 0);
  }

  public static void printNQueens(int[][] chess, String qsf, int row) {
    if (row == chess.length) {
      System.out.println(qsf + ".");
      return;
    }

    for (int col = 0; col < chess[0].length; col++) {
      if (isQueenSafe(chess, row, col)) {
        chess[row][col] = 1;
        printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
        chess[row][col] = 0;
      }
    }
  }

  public static boolean isQueenSafe(int[][] chess, int row, int col) {
    //  check vertically above
    for (int i = row - 1, j = col; i >= 0; i--) {
      if (chess[i][j] == 1) {
        return false;
      }
    }

    // check backward diagonally above
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (chess[i][j] == 1) {
        return false;
      }
    }

    // check forward diagonally above
    for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
      if (chess[i][j] == 1) {
        return false;
      }
    }

    return true;
  }
}
