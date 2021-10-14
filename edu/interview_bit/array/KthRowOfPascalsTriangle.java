package edu.interview_bit.array;

import java.util.ArrayList;

public class KthRowOfPascalsTriangle {

  public static void main(String[] args) {
    int row = 3;
    System.out.println(new KthRowOfPascalsTriangle().getRow(row));
  }

  /*
   * Let see how we can find next row from the current row
   *
   * Let say our current_row = [1] [3] [3] [1]
   *
   * Step-1: Append [1] at the beginning because first element will always be [1]
   *         now our array would be: [1] [1] [3] [3] [1]
   *
   * Step-2: Now from index 1 to (i-1)(because for ith row there will (i+1) elements in it
   *          in which we don't want to alter the last [1] and indices are 0 based)
   *          start updating the value by ith index with the sum of [i] + [i+1].
   *
   *       we get:- [1] [4] [6] [4] [1] (this is our next row)
   * */


  public ArrayList<Integer> getRow(int A) {
    ArrayList<Integer> l = new ArrayList<>();

      for (int i = 0; i <= A; i++) {
          l.add(0, 1);
          for (int j = 1; j < i; j++) {
              l.set(j, l.get(j) + l.get(j + 1));
          }
      }

      return l;
  }

    public ArrayList<Integer> getRowOptimized(int A) {
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            l.add(1);
            for (int j = l.size() - 2; j > 0; j--) {
                l.set(j, l.get(j) + l.get(j - 1));
            }
        }

        return l;
    }
}
