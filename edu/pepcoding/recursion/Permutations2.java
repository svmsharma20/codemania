package edu.pepcoding.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutations-ii-official/ojquestion
public class Permutations2 {

  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
    if (cb > tb) {
      if (ssf == ts) {
        System.out.println(asf);
      }
      return;
    }

    if (ssf < ts) {
      for (int i = 0; i < items.length; i++) {
        if (items[i] == 0) {
          items[i] = 1;
          permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
          items[i] = 0;
        }
      }
    }

    permutations(cb + 1, tb, items, ssf, ts, asf + "0");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }
}