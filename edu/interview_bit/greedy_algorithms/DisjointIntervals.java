package edu.interview_bit.greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class DisjointIntervals {

  /*
        -> Sort the intervals, with respect to their end points.
        -> Now, traverse through all the intervals, if we get two overlapping intervals, then greedily choose the interval with lower end point since, choosing it will ensure that intervals further can be accommodated without any overlap.
        -> Apply the same procedure for all the intervals and return the count of intervals which satisfy the above criteria.
    */
  public int solve(ArrayList<ArrayList<Integer>> A) {
    Collections.sort(A, (a,b) -> a.get(1)-b.get(1));

    int count = 1;

    int i=0;
    int j=1;
    while(j<A.size()){
      if(A.get(i).get(1)<A.get(j).get(0)){
        i = j;
        count++;
      }
      j++;
    }

    return count;
  }

}
