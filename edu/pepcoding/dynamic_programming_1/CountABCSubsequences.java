package edu.pepcoding.dynamic_programming_1;

import java.util.Scanner;

public class CountABCSubsequences {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-a+b+c+subsequences-official/ojquestion
  // https://youtu.be/IV9pbZsi5cc?list=TLGGsb6lXIykzRAxMTA2MjAyMQ

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(getSubSequenceCount(str));
  }

  private static int getSubSequenceCount(String str) {
    int a = 0;
    int ab = 0;
    int abc = 0;

    for (int i = 0; i < str.length(); i++) {
      switch (str.charAt(i)){
        case 'a':
          a = 2 * a + 1;
          break;

        case 'b':
          ab = 2 * ab + a;
          break;

        case 'c':
          abc = 2 * abc + ab;
      }
    }

    return abc;
  }
}
