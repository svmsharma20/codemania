package edu.pepcoding.tree;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/recover-bst/ojquestion
public class RecoverBst {

  static TreeNode firstMisMatch, secondMisMatch, prev;

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void recoverTree(TreeNode root) {
   TreeNode temp = firstMisMatch;
   firstMisMatch = secondMisMatch;
   secondMisMatch = temp;
  }

  public static void recoverTreeTraversal(TreeNode node) {
    if(node == null){
      return;
    }

    recoverTreeTraversal(node.left);

    if(prev != null && prev.val > node.val){
      secondMisMatch = node;
      if(firstMisMatch==null){
        firstMisMatch = prev;
      }
    }

    prev = node;
    recoverTreeTraversal(node.right);
  }
}
