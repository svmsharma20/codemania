package edu.tests;

/*
 * https://practice.geeksforgeeks.org/problems/copy-set-bits-in-range0623/1
 * */
public class CopySetBitsInRange {

  static int setSetBit(int x, int y, int l, int r) {
    int i = 1 << (l - 1);
    while (l <= r) {
      if ((y & i) != 0 && (x & i) == 0) {
        x += i;
      }
      i <<= 1;
      l++;
    }

    return x;
  }
}
