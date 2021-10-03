package edu.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * */
public class KidsWithTheGreatestNumberOfCandies {

  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new ArrayList<>();
    int max = candies[0];
    for (int i = 1; i < candies.length; i++) {
      if (candies[i] > max) {
        max = candies[i];
      }
    }
    int minNumberToBeGreatest = max - extraCandies;

    for (int i = 0; i < candies.length; i++) {
      if (candies[i] < minNumberToBeGreatest) {
        result.add(false);
      } else {
        result.add(true);
      }
    }

    return result;
  }
}
