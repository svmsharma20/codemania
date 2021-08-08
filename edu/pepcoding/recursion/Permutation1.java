package edu.pepcoding.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Permutation1 {

  public static void permutations(int[] boxes, int ci, int ti) {
    if (ti == 0) {
      String s = "";
      for (int i = 0; i < boxes.length; i++) {
        s += boxes[i];
      }
      System.out.println(s);
      return;
    }
    for (int i = 0; i < boxes.length; i++) {
      if (boxes[i] == 0) {
        boxes[i] = ci;
        permutations(boxes, ci + 1, ti - 1);
        boxes[i] = 0;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}
