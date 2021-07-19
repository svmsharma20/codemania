package edu.pepcoding.tree;

import java.util.Collections;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/mirror-generic-tree-official/ojquestion
// https://www.youtube.com/watch?v=PDjTi3WGSNA&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=20
public class MirrorAGenericTree {

  public static void mirror(Node node){
    for(Node child : node.children){
      mirror(child);
    }

    Collections.reverse(node.children);
  }

}
