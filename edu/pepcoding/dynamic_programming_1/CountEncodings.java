package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class CountEncodings {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-encodings-official/ojquestion
  // https://www.youtube.com/watch?v=jFZmBQ569So&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=20
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    System.out.println(getEncodingCount(str));
  }

  private static int getEncodingCount(String str) {
    int[] dp = new int[str.length()];
    dp[0] = 1;

    for (int i = 1; i < dp.length; i++) {
      int lenOfI = 0;
      int currentNum = Integer.parseInt(str.charAt(i)+"");
      int prevNum = Integer.parseInt(str.charAt(i-1)+"");
      int lastTwoNum = prevNum*10 + currentNum;

      if(currentNum>0){
        lenOfI += dp[i-1];
      }

      if(prevNum!=0 && lastTwoNum<27){
        if(i==1){
          lenOfI++;
        }else{
          lenOfI += dp[i-2];
        }
      }

      dp[i] = lenOfI;
    }

    return dp[dp.length-1];
  }
}
