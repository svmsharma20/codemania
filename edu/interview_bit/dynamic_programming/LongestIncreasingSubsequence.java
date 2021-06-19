package edu.interview_bit.dynamic_programming;

public class LongestIncreasingSubsequence {

  public int lis(final int[] A) {
    int[] dp = new int[A.length];
    int maxLen=0;

    for(int i=0; i<A.length; i++){
      int max = 0;
      for(int j=0; j<i; j++){
        if(A[j]<A[i]){
          max = Math.max(max, dp[j]);
        }
      }

      dp[i] = max + 1;
      maxLen = Math.max(maxLen, dp[i]);
    }

    return maxLen;
  }

}
