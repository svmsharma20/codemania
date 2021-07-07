package edu.pepcoding.tree;

import java.util.ArrayDeque;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/level-order-generic-tree-official/ojquestion
public class LevelOrderOfGenericTree {

  public static void levelOrder(Node node){
    ArrayDeque<Node> queue = new ArrayDeque<>();

    queue.add(node);

    while(!queue.isEmpty()){
      for(Node child : queue.peek().children){
        queue.add(child);
      }
      System.out.print(queue.pop().data + " ");
    }
    System.out.print(".");
  }

}
