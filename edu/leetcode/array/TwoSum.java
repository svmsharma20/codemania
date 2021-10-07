package edu.leetcode.array;

import java.util.HashMap;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        int[] res = new int[2];
        res[0] = map.get(target - nums[i]);
        res[1] = i;
        return res;
      } else {
        map.put(nums[i], i);
      }
    }
    return null;
  }
}
