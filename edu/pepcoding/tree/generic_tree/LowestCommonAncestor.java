package edu.pepcoding.tree.generic_tree;

import java.util.ArrayList;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/lca-generic-tree-official/ojquestion
// https://www.youtube.com/watch?v=w8rr1AYMlfw&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=31
public class LowestCommonAncestor {

  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }

  public static int lca(Node node, int d1, int d2) {
    ArrayList<Integer> l1 = nodeToRootPath(node, d1);
    ArrayList<Integer> l2 = nodeToRootPath(node, d2);

    int lca = node.data;

    for(int i=l1.size()-1, j = l2.size()-1; i>=0 && j>=0; i--, j--){
      if(l1.get(i) == l2.get(j)){
        lca = l1.get(i);
      }else{
        break;
      }
    }

    return lca;
  }

}
