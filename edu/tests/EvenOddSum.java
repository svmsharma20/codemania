package edu.tests;

/*
 * After removing a single element sum of even index numbers and odd index numbers should be equal
 * */
public class EvenOddSum {

  public static void main(String[] args) {
    int[] arr = {7, 1, 9, 4, 5, 3, 15, 7, 5};
    System.out.println(getEqualSumAfterRemove(arr));
  }

  private static int getEqualSumAfterRemove(int[] arr) {
    int len = arr.length;

    int[] prefixSum = new int[arr.length];

    int[] suffixSum = new int[arr.length];
    suffixSum[0] = arr[0];
    suffixSum[1] = arr[1];

    for (int i = 0; i < arr.length; i++) {
      if (i - 2 < 0) {
        prefixSum[i] = arr[i];
      } else {
        prefixSum[i] = prefixSum[i - 2] + arr[i];
      }
    }

    for (int i = len - 1; i >= 0; i--) {
      if (i + 2 >= len) {
        suffixSum[i] = arr[i];
      } else {
        suffixSum[i] = suffixSum[i + 2] + arr[i];
      }
    }

    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        if ((suffixSum[i] - arr[i] == suffixSum[i + 1])) {
          return i;
        }
      } else if (i == len - 1) {
        if (prefixSum[i] - arr[i] == prefixSum[i - 1]) {
          return i;
        }
      } else {
        int sum1 = prefixSum[i - 1] + suffixSum[i];
        int sum2 = prefixSum[i] + suffixSum[i + 1];
        if (sum1 == sum2) {
          return i;
        }
      }
    }
    return -1;
  }
}
