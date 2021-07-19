package edu.pepcoding.tree;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/remove-leaves-generic-tree-official/ojquestion
// https://www.youtube.com/watch?v=0PBC_EEBHGg&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=22
public class RemoveLeavesInGenericTree {

  public static void removeLeaves(Node node) {
    for(int i = node.children.size()-1; i>=0; i--){
      Node child = node.children.get(i);
      if(child.children.size() == 0){
        node.children.remove(i);
      }
    }

    for(Node child : node.children){
      removeLeaves(child);
    }
  }

}
