package edu.pepcoding.tree.generic_tree;

import java.util.Stack;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/iterative-preorder-postorder-generic-tree-official/ojquestion
// https://www.youtube.com/watch?v=5ry6gRrzPqc&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=52
public class IterativePreorderAndPostorderOfGenericTree {

  private static class Pair{
    Node node;
    int state;
    Pair(Node node, int state){
      this.node = node;
      this.state = state;
    }
  }

  public static void IterativePreandPostOrder(Node node) {
    Stack<Pair> stack = new Stack<>();

    String preOrder = "";
    String postOrder = "";

    stack.push(new Pair(node, -1));

    while(!stack.isEmpty()){
      Pair peek = stack.peek();
      int val = peek.state;
      if(val == -1){
        preOrder += peek.node.data + " ";
        peek.state = 0;
      } else if(val == peek.node.children.size()){
        postOrder += peek.node.data + " ";
        stack.pop();
      } else {
        Pair newChild = new Pair(peek.node.children.get(val), -1);
        peek.state = val+1;
        stack.push(newChild);
      }
    }

    System.out.println(preOrder);
    System.out.println(postOrder);
  }
}
