package edu.pepcoding.tree.generic_tree;

// https://www.youtube.com/watch?v=GIA2cZgOdwg&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=50
// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/diameter-of-generic-tree-official/ojquestion
public class DiameterOfAGenericTree {

  static int dia = 0;

  public static int diameter(Node node){
    int dch = -1;
    int sdch = -1;

    for(Node child: node.children){
      int ch = diameter(child);
      if(dch < ch){
        sdch = dch;
        dch = ch;
      }else if(sdch < ch){
        sdch = ch;
      }
    }
    int cand = dch + sdch + 2;
    if(dia < cand){
      dia = cand;
    }

    return dch+1;
  }
}
