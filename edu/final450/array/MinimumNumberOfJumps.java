package edu.final450.array;

public class MinimumNumberOfJumps {

  public static void main(String[] args) {
    int arr[] = {1, 3, 5, 9, 2, 2, 6, 7, 6, 8, 9};
    System.out.println(getMinJumps(arr));
  }

  private static int getMinJumps(int[] A) {
    if (A.length <= 1) {
      return 0;
    }

    int maxReach = A[0];
    int step = A[0];
    int jump = 1;

    for (int i = 1; i < A.length; i++) {
      if (i >= A.length - 1) {
        return jump;
      }

      if (A[i] + i > maxReach) {
        maxReach = A[i] + i;
      }

      step--;
      if (step == 0) {
        jump++;
        step = maxReach - i;
      }
    }

    return jump;
  }
}
