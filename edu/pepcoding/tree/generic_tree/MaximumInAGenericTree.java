package edu.pepcoding.tree.generic_tree;

import java.util.ArrayList;
import java.util.Stack;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/max-generic-tree-official/ojquestion
// https://www.youtube.com/watch?v=FqONnzlCSWQ&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=6
public class MaximumInAGenericTree {

  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static int max(Node node) {
    if(node == null){
      return -1;
    }

    int max = Integer.MIN_VALUE;

    Stack<Node> stack = new Stack<>();
    stack.push(node);

    while(!stack.isEmpty()){
      max = Math.max(max, stack.peek().data);

      for(Node child : stack.pop().children){
        stack.push(child);
      }
    }

    return max;
  }
}
