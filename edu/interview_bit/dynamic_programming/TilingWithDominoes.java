package edu.interview_bit.dynamic_programming;

public class TilingWithDominoes {

  // https://tutorialspoint.dev/algorithm/dynamic-programming-algorithms/tiling-with-dominoes
  public int solve(int A) {
    int MOD = 1000000007;
    long[] dpA = new long[A+1];
    long[] dpB = new long[A+1];

    dpA[0] = 1;
    dpA[1] = 0;

    dpB[0] = 0;
    dpB[1] = 1;

    for(int i=2; i<=A; i++){
      dpA[i] = (dpA[i-2] + 2 * dpB[i-1]) % MOD;
      dpB[i] = (dpA[i-1] + dpB[i-2]) % MOD;
    }

    return (int)dpA[A];
  }

}
