package edu.interview_bit.binary_search;

import java.util.ArrayList;

public class SortedInsertPosition {

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(6);
    list.add(9);
    list.add(12);
    list.add(15);
    list.add(18);
    list.add(21);

    System.out.println(new SortedInsertPosition().searchInsert(list, 6));
  }

  public int searchInsert(ArrayList<Integer> a, int b) {
    int expectedPos = -1;

    int low = 0;
    int high = a.size()-1;

    while (low<=high){
      int mid = low + (high-low)/2;
      if(a.get(mid)==b){
        return mid;
      }else if(a.get(mid)>b){
        expectedPos = mid;
        high = mid-1;
      }else{
        expectedPos = mid+1;
        low = mid+1;
      }
    }

    return expectedPos;
  }
}
