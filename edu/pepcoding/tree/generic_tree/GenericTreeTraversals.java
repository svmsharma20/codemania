package edu.pepcoding.tree.generic_tree;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/generic-tree-traversal-official/ojquestion
// https://www.youtube.com/watch?v=YnufWAWOfI8&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=11
public class GenericTreeTraversals {

  public static void traversals(Node node){
    System.out.println("Node Pre "+node.data);
    for(Node child : node.children){
      System.out.println("Edge Pre "+node.data+"--"+child.data);
      traversals(child);
      System.out.println("Edge Post "+node.data+"--"+child.data);
    }
    System.out.println("Node Post "+node.data);
  }
}
