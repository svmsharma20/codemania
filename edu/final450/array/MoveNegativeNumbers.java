package edu.final450.array;

import java.util.Arrays;

public class MoveNegativeNumbers {

  public static void main(String[] args) {
    int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
    moveNegatives(arr);
    Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
  }

  private static void moveNegatives(int[] arr) {
    int i = 0;
    int j = arr.length;

    while (i < j) {
      if (arr[i] > 0) {
        j--;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      } else {
        i++;
      }
    }
  }
}
