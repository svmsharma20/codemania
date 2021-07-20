package edu.pepcoding.tree.generic_tree;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/height-of-generic-tree-official/ojquestion
public class HeightOfAGenericTree {

  public static int height(Node node) {
    if(node == null){
      return -1;
    }

    int height = -1;

    for(Node child : node.children){
      height = Math.max(height, height(child));
    }

    height++;
    return height;
  }
}
