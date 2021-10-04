package edu.leetcode.array.easy;

/*
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * */
public class NumbersSmallerThanCurrentNumber {

  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] arr = new int[101];               // As per the constraints
    for (int i = 0; i < nums.length; i++) {
      arr[nums[i]]++;
    }

    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      arr[i] = sum;
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] = nums[i] == 0 ? 0 : arr[nums[i] - 1];
    }
    return result;
  }
}
