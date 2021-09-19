package edu.tests;

// https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
public class Powerof2 {

  public static boolean isPowerofTwo(long n) {

    if (n == 0) {
      return false;
    }

    return (n & (n - 1)) == 0;
  }
}
