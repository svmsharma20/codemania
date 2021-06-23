package edu.pepcoding.dynamic_programming_2;

import java.util.HashMap;
import java.util.Scanner;

public class CountDistinctSubsequences {

  // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-distinct-subsequences-official/ojquestion
  // https://youtu.be/9UEHPiK53BA?list=TLGGe1zL7Z3kqSAyMzA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.next();

    System.out.println(getDistinctCount(str));
  }

  private static long getDistinctCount(String str) {
    long[] dp = new long[str.length()+1];
    dp[0] = 1;

    HashMap<Character, Integer> indexMap = new HashMap<>();

    for (int i = 1; i <= str.length(); i++) {

      dp[i] = 2 * dp[i-1] ;
      char ch = str.charAt(i-1);

      if(indexMap.containsKey(ch)){
        int j = indexMap.get(ch);
        dp[i] = dp[i] - dp[j-1];
      }
      indexMap.put(ch, i);

    }

    return dp[str.length()]-1;
  }
}
