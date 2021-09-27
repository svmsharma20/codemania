package edu.final450.array;

public class KadanesAlgorithm {

  long maxSubarraySum(int arr[], int n) {
    long maxSum = Long.MIN_VALUE;

    long sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum > maxSum) {
        maxSum = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
    }

    return maxSum;
  }
}
