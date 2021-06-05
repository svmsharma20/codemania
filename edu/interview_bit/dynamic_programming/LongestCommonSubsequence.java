package edu.interview_bit.dynamic_programming;

public class LongestCommonSubsequence {

  static int[][] dp ;
  public static void main(String[] args) {
    String s1 = "ABGHISTR";
    String s2 = "AQIDNISRC";
    dp = new int[s1.length()+1][s2.length()+1];
    System.out.println(new LongestCommonSubsequence().getLCS(s1, s2));
  }

  public int getLCS(String A, String B) {
    int i = A.length();
    int j = B.length();
    if(i==0 || j==0){
      return 0;
    }

    if(dp[i][j]!=0){
      return dp[i][j];
    }
    int lcs = -1;
    if(A.charAt(i-1) == B.charAt(j-1)){
      lcs = 1 + getLCS(A.substring(0, i-1), B.substring(0, j-1));
    }else{
      lcs = Math.max(getLCS(A.substring(0, i-1), B.substring(0, j)),
                     getLCS(A.substring(0, i), B.substring(0, j-1)));
    }
    dp[i][j] = lcs;
    return lcs;
  }
}
