package edu.leetcode.array.easy;

/*
 * https://leetcode.com/problems/richest-customer-wealth/
 * */
public class RichestCustomerWealth {

  public int maximumWealth(int[][] accounts) {
    int maxWealth = 0;

    for (int i = 0; i < accounts.length; i++) {
      int wealth = 0;
      for (int j = 0; j < accounts[i].length; j++) {
        wealth += accounts[i][j];
      }
      maxWealth = maxWealth < wealth ? wealth : maxWealth;
    }

    return maxWealth;
  }
}
