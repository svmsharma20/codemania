package edu.tests;

public class BeggarsOutsideTemple {

  public static void main(String[] args) {
    int[][] devotees = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
    int beggars = 5;

    int[] finalArr = getFinalAmounts(devotees, beggars);
    for (int i = 0; i < finalArr.length; i++) {
      System.out.print(finalArr[i] + " ");
    }
  }

  private static int[] getFinalAmounts(int[][] devotees, int beggars) {
    int[] beggarBowls = new int[beggars];
    for (int i = 0; i < devotees.length; i++) {
      beggarBowls[devotees[i][0] - 1] += devotees[i][2];
      if (devotees[i][1] != beggarBowls.length) {
        beggarBowls[devotees[i][1]] -= devotees[i][2];
      }
    }

    for (int i = 1; i < beggarBowls.length; i++) {
      beggarBowls[i] += beggarBowls[i - 1];
    }

    return beggarBowls;
  }
}
