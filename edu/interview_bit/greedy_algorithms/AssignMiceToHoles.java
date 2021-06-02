package edu.interview_bit.greedy_algorithms;

import java.util.Arrays;

public class AssignMiceToHoles {

  public static void main(String[] args) {

  }

  public int mice(int[] A, int[] B) {
    Arrays.sort(A);
    Arrays.sort(B);

    int maxTime = 0;
    for (int i = 0; i < A.length; i++) {
      maxTime = Math.max(maxTime, Math.abs(A[i]-B[i]));
    }

    return maxTime;
  }
}
