package edu.pepcoding.tree;

import edu.pepcoding.tree.model.TreeNode;

public class ValidateBst {

  public static class NodePair {

    boolean isValid;
    int min;
    int max;

    NodePair(boolean isValid, int max, int min) {
      this.isValid = isValid;
      this.min = min;
      this.max = max;
    }
  }

  public static boolean isValidBST(TreeNode root) {
    return checkBST(root).isValid;
  }

  public static NodePair checkBST(TreeNode root) {
    if(root == null){
      return new NodePair(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    NodePair leftBST = checkBST(root.left);
    NodePair rightBST = checkBST(root.right);

    int max = Math.max(rightBST.max, root.val);
    int min = Math.min(leftBST.min, root.val);

    if(!leftBST.isValid || !rightBST.isValid){
      return new NodePair(false, max, min);
    }

    if(root.val < leftBST.max){
      return new NodePair(false, max, min);
    }

    if(root.val > rightBST.min){
      return new NodePair(false, max, min);
    }

    return new NodePair(true, max, min);
  }
}
