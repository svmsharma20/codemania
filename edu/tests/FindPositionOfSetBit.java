package edu.tests;

// https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1
public class FindPositionOfSetBit {

  static int findPosition(int N) {
    if (N == 0 || (N & (N - 1)) != 0) {
      return -1;
    }

    int pos = 0;
    while (N > 0) {
      pos++;
      N >>= 1;
    }

    return pos;
  }
}
