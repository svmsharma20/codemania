package edu.tests;

public class ChangeTheArray {

  public static void main(String[] args) {
    int[] A = {8, 15, 16, 3, 10};
    int[] B = {2, 1, 1};
    int[] C = {2, 3, 1};

    System.out.println(getMinSum(A, B, C));
  }

  private static int getMinSum(int[] a, int[] b, int[] c) {
    int[] arrA = new int[106];
    int[] arrC = new int[106];
    int sum = 0;

    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      arrA[a[i]]++;
    }

    for (int i = 0; i < c.length; i++) {
      arrC[c[i]] += b[i];
    }

    for (int i = arrA.length - 1, j = 1; j < i && j < arrC.length; i--) {
      if (arrA[i] == 0) {
        continue;
      }

      while (j < arrC.length && arrC[j] == 0) {
        j++;
      }

      sum = sum - i + j;
      arrC[j]--;
    }

    return sum;
  }
}
