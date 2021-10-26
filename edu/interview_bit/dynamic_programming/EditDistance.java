package edu.interview_bit.dynamic_programming;

/*
 * https://www.youtube.com/watch?v=AuYujVj646Q&t=731s
 * */
public class EditDistance {

    public int minDistance(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Insert
                    int min = dp[i - 1][j] + 1;

                    // Replace
                    min = Math.min(min, dp[i - 1][j - 1] + 1);

                    // Delete
                    min = Math.min(min, dp[i][j - 1] + 1);
                    dp[i][j] = min;
                }
            }
        }

        return dp[A.length()][B.length()];
    }
}
