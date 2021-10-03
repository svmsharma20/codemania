package edu.leetcode.array.easy;

/*
 * https://leetcode.com/problems/shuffle-the-array/
 * */
public class ShuffleTheArray {

  public int[] shuffle(int[] nums, int n) {
    int upperBound = 1001; // take any number greater than 10^3
    for (int i = n; i < 2 * n; i++) {
      nums[i] = nums[i - n] * upperBound + nums[i];
    }

    int j = 0;
    for (int i = n; i < 2 * n; i++) {
      nums[j] = nums[i] / upperBound;
      nums[j + 1] = nums[i] % upperBound;
      j += 2;
    }
    return nums;
  }
}
