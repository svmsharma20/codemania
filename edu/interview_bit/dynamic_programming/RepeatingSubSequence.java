package edu.interview_bit.dynamic_programming;

/*
 * https://www.youtube.com/watch?v=oL7GCrcdaJI&t=186s
 * */
public class RepeatingSubSequence {

    public int anytwo(String A) {
        int[][] dp = new int[A.length() + 1][A.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 || j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else if (i != j && A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0] >= 2 ? 1 : 0;
    }
}
