package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class ArrangeBuildings {

  public static void main(String[] args) {
    long n = new Scanner(System.in).nextLong();

    System.out.println(getTotalArrangement(n));
  }

  private static long getTotalArrangement(long n) {
    if(n==0){
      return 0;
    }
    long prevB = 1;
    long prevS = 1;

    for (int i = 2; i <= n; i++) {
      long currentB = prevS;
      long currentS = prevB+prevS;
      prevB = currentB;
      prevS = currentS;
    }

    long totalArrangementsPerSide = prevB + prevS;
    return totalArrangementsPerSide * totalArrangementsPerSide;
  }
}
