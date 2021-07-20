package edu.pepcoding.tree.generic_tree;

import java.util.ArrayDeque;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/levelorder-linewise-generic-tree-official/ojquestion
public class LevelorderLinewise {

  public static void levelOrderLinewise(Node node){
    Node invNode = new Node();
    invNode.data = -1;
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.add(node);
    queue.add(invNode);
    String str = "";
    while(!queue.isEmpty()){
      Node peek = queue.removeFirst();
      if(peek.data == -1){
        System.out.println(str);
        str = "";
        if(!queue.isEmpty()){
          queue.add(invNode);
        }
      }else{
        str += peek.data + " ";
        for(Node child : peek.children){
          queue.add(child);
        }
      }
    }
  }
}
