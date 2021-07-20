package edu.pepcoding.tree.generic_tree;

import java.util.ArrayList;
import java.util.Stack;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/size-generic-tree-official/ojquestion
// https://www.youtube.com/watch?v=epQq3XWitxA&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=5
public class SizeOfGenericTree {

  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static int size(Node node){
    if(node == null){
      return 0;
    }

    int size = 0;

    Stack<Node> stack = new Stack<>();
    stack.push(node);

    while(!stack.isEmpty()){
      size++;

      for(Node child : stack.pop().children){
        stack.push(child);
      }
    }

    return size;
  }
}
