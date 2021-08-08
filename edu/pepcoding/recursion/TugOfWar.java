package edu.pepcoding.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class TugOfWar {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int[] arr = new int[scn.nextInt()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
    System.out.println(ans);
  }

  static int mindiff = Integer.MAX_VALUE;
  static String ans = "";

  public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2,
      int soset1, int soset2) {
    if (vidx == arr.length) {
      int diff = Math.abs(soset1 - soset2);
      int noe1 = set1.size();
      int noe2 = set2.size();
      int diffInSize = Math.abs(noe1 - noe2);
      if (diffInSize <= 1 && diff < mindiff) {
        mindiff = diff;
        ans = set1.toString() + " " + set2.toString();
      }
      return;
    }

    set1.add(arr[vidx]);
    solve(arr, vidx + 1, set1, set2, soset1 + arr[vidx], soset2);
    set1.remove((Integer) arr[vidx]);

    set2.add(arr[vidx]);
    solve(arr, vidx + 1, set1, set2, soset1, soset2 + arr[vidx]);
    set2.remove((Integer) arr[vidx]);
  }

}
