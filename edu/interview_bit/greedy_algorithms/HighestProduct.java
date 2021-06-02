package edu.interview_bit.greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProduct {

  public int maxp3(ArrayList<Integer> a) {
    Collections.sort(a);
    int size=a.size();

    /*The only possibilities for maximum product is:
    * (1) Product of three largest positive number
    * (2) Product of two smallest negative number and one largest maximum number
    * */

    if(a.get(size-1)<0)
      return a.get(size-1)*a.get(size-2)*a.get(size-3);
    // x will be greater if two negative numbers are present in the start and,
    // their absolute value is largest in the whole array
    int x = a.get(1)*a.get(0);
    int y = a.get(size-2)*a.get(size-3);
    return x>y? a.get(size-1)*x : a.get(size-1)*y;
  }
}
