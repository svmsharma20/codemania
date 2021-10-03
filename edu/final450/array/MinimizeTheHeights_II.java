package edu.final450.array;

import java.util.Arrays;

/*
  https://stackoverflow.com/a/65880544
*/

public class MinimizeTheHeights_II {

  public static void main(String[] args) {
    int[] arr = {3, 9, 12, 16, 20};
    System.out.println(getMinHeight(arr, 3));
  }

  private static int getMinHeight(int[] arr, int k) {
    Arrays.sort(arr);
    int n = arr.length;
    int ans = arr[n - 1] - arr[0];
    int smallest = arr[0] + k;
    int largest = arr[n - 1] - k;

    for (int i = 0; i < n - 1; i++) {
      int min = Math.min(smallest, arr[i + 1] - k);
      int max = Math.max(largest, arr[i] + k);
      if (min < 0) {
        continue;
      }
      ans = Math.min(ans, max - min);
    }

    return ans;
  }
}
