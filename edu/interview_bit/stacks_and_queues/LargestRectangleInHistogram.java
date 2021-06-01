package edu.interview_bit.stacks_and_queues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {

  // https://www.youtube.com/watch?v=vcv3REtIvEo
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>();
    A.add(2);
    A.add(1);
    A.add(5);
    A.add(6);
    A.add(2);
    A.add(3);

    System.out.println(new LargestRectangleInHistogram().largestRectangleArea(A));
  }

  public int largestRectangleArea(ArrayList<Integer> A) {
    if(A==null || A.size()==0){
      return 0;
    }

    Stack<Integer> stack = new Stack<>();

    int[] leftLimit = new int[A.size()];
    int[] rightLimit = new int[A.size()];

    int maxArea = 0;

    for (int i = 0; i < leftLimit.length; i++) {
      while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)){
        stack.pop();
      }
      if(stack.isEmpty()){
          leftLimit[i] = 0;
      }else{
        leftLimit[i] = stack.peek()+1;
      }
      stack.push(i);
    }

    stack.clear();

    for (int i = rightLimit.length-1; i >= 0; i--) {
      while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)){
        stack.pop();
      }
      if(stack.isEmpty()){
        rightLimit[i] = A.size()-1;
      }else{
        rightLimit[i] = stack.peek()-1;
      }
      stack.push(i);
    }

    for (int i = 0; i < leftLimit.length; i++) {
      int area = A.get(i) * (rightLimit[i]-leftLimit[i]+1);
      maxArea = Math.max(maxArea, area);
    }

    return maxArea;
  }
}
