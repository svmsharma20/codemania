package edu.leetcode.array.easy;

/*
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 * */
public class FinalValueOfVariableAfterPerformingOperations {

  public int finalValueAfterOperations(String[] operations) {
    int x = 0;
    for (String s : operations) {
      if (s.charAt(0) == '+' || s.charAt(2) == '+') {
        x++;
      } else {
        x--;
      }
    }

    return x;
  }
}
