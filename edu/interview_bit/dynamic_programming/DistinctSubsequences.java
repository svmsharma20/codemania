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

    public int numDistinctIter(String A, String B) {
        int[][] dp = new int[B.length() + 1][A.length() + 1];
        dp[B.length()][A.length()] = 1;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (i == dp.length - 1) {
                    dp[i][j] = 1;
                } else if (A.charAt(j) == B.charAt(i)) {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String A = "aaaababbababbaabbaaababaaabbbaaabbb";
        String B = "bbababa";

        System.out.println(new DistinctSubsequences().numDistinctIter(A, B));
    }
}
