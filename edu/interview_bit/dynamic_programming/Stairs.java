package edu.interview_bit.dynamic_programming;

public class Stairs {

  public int climbStairs(int A) {

    int dpIm2 = 1;
    int dpIm1 = 1;
    int dpI = 1;
    for(int i=2; i<=A; i++){
      dpI = dpIm2 + dpIm1;
      dpIm2 = dpIm1;
      dpIm1 = dpI;
    }

    return dpI;
  }
}
