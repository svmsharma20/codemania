package edu.interview_bit.stacks_and_queues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>();
    A.add(3);
    A.add(1);
    A.add(2);
    A.add(5);
    A.add(3);
    A.add(7);
    A.add(1);
    A.add(1);
    A.add(1);

    int B = 3;

    System.out.println(new SlidingWindowMaximum().slidingMaximum(A, B));
  }

  // https://www.youtube.com/watch?v=39grPZtywyQ
  private ArrayList<Integer> slidingMaximum(ArrayList<Integer> A, int B) {
    if(A==null){
      return null;
    }

    Deque<Integer> window = new LinkedList<>();
    ArrayList<Integer> maxList = new ArrayList<>();

    int i=0;

    while (i<A.size()){
      if(!window.isEmpty() && window.getFirst()<=(i-B)){
        window.removeFirst();
      }else if(!window.isEmpty() && A.get(window.getLast())<=A.get(i)){
        window.removeLast();
      }else{
        /*Note that we are adding index and not the actual value*/
        window.add(i);
        if(i>=(B-1)){
          maxList.add(A.get(window.getFirst()));
        }
        i++;
      }
    }

    if(maxList.isEmpty() && A.size()<=B){
      maxList.add(window.getFirst());
      return maxList;
    }

    return maxList;
  }

  public ArrayList<Integer> slidingMaximumUsingPriorityQueue(final List<Integer> A, int B) {
    if(A==null){
      return null;
    }

    ArrayList<Integer> maxList = new ArrayList<>();
    PriorityQueue<Integer> window = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < B && i < A.size(); i++) {
      window.add(A.get(i));
    }
    if(window.size()==A.size()){
      maxList.add(window.peek());
      return maxList;
    }

    int left=0;
    int right = B-1;

    while(right<A.size()){
      maxList.add(window.peek());
      window.remove(A.get(left));
      left++;
      right++;
      if(right<A.size()){
        window.add(A.get(right));
      }
    }

    return maxList;
  }
}
