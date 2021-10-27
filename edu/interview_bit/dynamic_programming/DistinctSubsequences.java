package edu.interview_bit.dynamic_programming;

/*
 * https://www.youtube.com/watch?v=-RDzMJ33nx8
 * */
public class DistinctSubsequences {

    int[][] dp;

    public int numDistinct(String A, String B) {
        dp = new int[A.length()][B.length()];
        return dfs(A, B, 0, 0);
    }

    public int dfs(String s1, String s2, int i, int j) {
        if (j == s2.length()) {
            return 1;
        }
        if (i == s1.length()) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = dfs(s1, s2, i + 1, j + 1) + dfs(s1, s2, i + 1, j);
        } else {
            dp[i][j] = dfs(s1, s2, i + 1, j);
        }

        return dp[i][j];
    }
}
