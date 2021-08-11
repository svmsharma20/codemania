package edu.pepcoding.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/combinations-2-official/ojquestion
public class Combinations2 {

  public static void combinations(int[] boxes, int ci, int ti, int lb) {
    if (ci > ti) {
      String s = "";

      for (int i = 0; i < boxes.length; i++) {
        if (boxes[i] == 1) {
          s += "i";
        } else {
          s += "-";
        }
      }

      System.out.println(s);
      return;
    }

    for (int i = lb + 1; i < boxes.length; i++) {
      boxes[i] = 1;
      combinations(boxes, ci + 1, ti, i);
      boxes[i] = 0;

    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}
