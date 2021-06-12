package edu.pepcoding.dynamic_programming;

import java.util.Scanner;

public class PaintFence {

  // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-fence-official/ojquestion
  // https://youtu.be/ju8vrEAsa3Q?list=TLGGBVZP0QjfybUxMjA2MjAyMQ
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    int same = k;
    int diff = k * (k-1);
    int total = same + diff;

    for (int i = 3; i <= n; i++) {
        same = diff;
        diff = total * (k-1);
        total = same + diff;
    }

    System.out.println(total);
  }
}
