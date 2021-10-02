package edu.tests;

public class MinMaxSubArray {

  public static void main(String[] args) {
    int[] arr = {9, 7, 10, 7, 2, 1, 6, 4, 1, 2, 7, 5, 10, 9, 2, 1};
    System.out.println(getMinMaxSubArray(arr));
  }

  private static int getMinMaxSubArray(int[] arr) {
    int minIndex = 0;
    int maxIndex = 0;
    int diffLen = Integer.MAX_VALUE;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > arr[maxIndex]) {
        maxIndex = i;
        diffLen = Math.abs(maxIndex - minIndex);
      }

      if (arr[i] < arr[minIndex]) {
        minIndex = i;
        diffLen = Math.abs(maxIndex - minIndex);
      }

      if (arr[i] == arr[minIndex]) {
        minIndex = i;
        if (diffLen > Math.abs(maxIndex - i)) {
          diffLen = Math.abs(maxIndex - minIndex);
        }
      }

      if (arr[i] == arr[maxIndex]) {
        maxIndex = i;
        if (diffLen > Math.abs(minIndex - i)) {
          diffLen = Math.abs(maxIndex - minIndex);
        }
      }
    }
    return diffLen + 1;
  }
}
