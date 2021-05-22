package edu.interview_bit.array;

import java.util.ArrayList;

public class MaxMin {

  public static void main(String[] args) {

    ArrayList<Integer> maxMin = new ArrayList<>();
    maxMin.add(-2);
    maxMin.add(1);
    maxMin.add(-4);
    maxMin.add(5);
    maxMin.add(3);

    System.out.println(new MaxMin().solve(maxMin));
  }

  public int solve(ArrayList<Integer> A) {
    ArrayList<Integer> maxMin = getMaxMin(A, 0, A.size()-1);
    return maxMin.get(0) + maxMin.get(1);
  }


  /*
  * Returns an arraylist with:
  *    0th index: Max in current interval(that is left interval + right interval)
  *    1st index: Min in current interval(that is left interval + right interval)
  */

  ArrayList<Integer> getMaxMin(ArrayList<Integer> list, int start, int end){
    ArrayList<Integer> maxMin = new ArrayList<>();

    if(start==end){
      maxMin.add(list.get(start));
      maxMin.add(list.get(end));
      return maxMin;
    }

    int mid = start + (end-start)/2;
    ArrayList<Integer> leftMaxMin = getMaxMin(list, start, mid);
    ArrayList<Integer> rightMaxMin = getMaxMin(list, mid+1, end);

    if(leftMaxMin.get(0)>rightMaxMin.get(0)){
      maxMin.add(leftMaxMin.get(0));
    }else{
      maxMin.add(rightMaxMin.get(0));
    }

    if(leftMaxMin.get(1)<rightMaxMin.get(1)){
      maxMin.add(leftMaxMin.get(1));
    }else{
      maxMin.add(rightMaxMin.get(1));
    }

    return maxMin;
  }
}
