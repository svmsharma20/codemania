package edu.leetcode.array.easy;

/*
 * https://leetcode.com/problems/build-array-from-permutation/
 * */
public class BuildArrayFromPermutation {

  public int[] buildArray(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < nums.length; i++) {
      int r = nums[i];
      int q = nums[r] % len;
      nums[i] = q * len + r;
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i] / len;
    }
    return nums;
  }
}
