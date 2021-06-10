package edu.pepcoding.dynamic_programming;

import java.util.Scanner;

public class CountBinaryStrings {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-binary-strings-official/ojquestion
  // https://www.youtube.com/watch?v=nqrXHJWMeBc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=18
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(getCount(n));
  }

  private static int getCount(int n) {
    if(n==0){
      return 0;
    }

    if(n==1){
      return 2;
    }

    int prev0 = 1;
    int prev1 = 1;
    int current0 = -1;
    int current1 = -1;

    for (int i = 2; i <= n; i++) {
      current0 = prev1;
      current1 = prev1 + prev0;
      prev0 = current0;
      prev1 = current1;
    }

    return current0+current1;
  }
}
