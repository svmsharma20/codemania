package edu.pepcoding.recursion;

import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/crossword-puzzle-official/ojquestion
public class CrosswordPuzzle {

  public static void solution(char[][] arr, String[] words, int vidx) {
    if (vidx == words.length) {
      print(arr);
      return;
    }
    String word = words[vidx];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
          if (isHzPossible(arr, word, i, j)) {
            String prev = "";
            for (int k = 0; k < word.length(); k++) {
              prev += arr[i][j + k];
              arr[i][j + k] = word.charAt(k);
            }
            solution(arr, words, vidx + 1);
            for (int k = 0; k < prev.length(); k++) {
              arr[i][j + k] = prev.charAt(k);
            }
          }

          if (isVtPossible(arr, word, i, j)) {
            String prev = "";
            for (int k = 0; k < word.length(); k++) {
              prev += arr[i + k][j];
              arr[i + k][j] = word.charAt(k);
            }
            solution(arr, words, vidx + 1);
            for (int k = 0; k < prev.length(); k++) {
              arr[i + k][j] = prev.charAt(k);
            }
          }
        }
      }
    }
  }


  public static boolean isHzPossible(char[][] arr, String word, int i, int j) {
    int len = word.length();
    if (len + j > arr[0].length) {
      return false;
    }

    if (j != 0 && arr[i][j - 1] != '+') {
      return false;
    }

    for (int k = 0; k < len; k++) {
      if (arr[i][j + k] != '-' && arr[i][j + k] != word.charAt(k)) {
        return false;
      }
    }

    if (j + len != arr[0].length && arr[i][j + len] != '+') {
      return false;
    }

    return true;
  }

  public static boolean isVtPossible(char[][] arr, String word, int i, int j) {
    int len = word.length();
    if (len + i > arr.length) {
      return false;
    }

    if (i > 0 && arr[i - 1][j] != '+') {
      return false;
    }

    for (int k = 0; k < len; k++) {
      if (arr[i + k][j] != '-' && arr[i + k][j] != word.charAt(k)) {
        return false;
      }
    }

    if (i + len < arr.length && arr[i + len][j] != '+') {
      return false;
    }

    return true;
  }

  public static void print(char[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0; i < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}
