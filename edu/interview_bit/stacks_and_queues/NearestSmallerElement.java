package edu.interview_bit.stacks_and_queues;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

  public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
    if(A==null || A.size()==0){
      return A;
    }
    Stack<Integer> minStack = new Stack<>();
    ArrayList<Integer> nearestMinList = new ArrayList<>();

    for(int i=0; i<A.size(); i++){
      while(!minStack.isEmpty() && minStack.peek()>=A.get(i)){
        minStack.pop();
      }
      if(minStack.isEmpty()){
        nearestMinList.add(-1);
      }else{
        nearestMinList.add(minStack.peek());
      }
      minStack.push(A.get(i));
    }

    return nearestMinList;
  }

}
