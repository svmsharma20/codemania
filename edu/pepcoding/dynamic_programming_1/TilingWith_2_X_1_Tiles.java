package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class TilingWith_2_X_1_Tiles {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tiling1-official/ojquestion
  // https://youtu.be/dVT9JeUMMDE?list=TLGGQJvNdOZBSRwxMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(getWaysToTile(n));
  }

  private static int getWaysToTile(int n) {
    if(n==1){
      return 1;
    }
    if(n==2){
      return 2;
    }

    int f1 = 1;
    int f2 = 2;
    int count = 0;
    for (int i = 3; i <= n; i++) {
      count = f2 + f1;
      f1 = f2;
      f2 = count;
    }
    return count;
  }
}
