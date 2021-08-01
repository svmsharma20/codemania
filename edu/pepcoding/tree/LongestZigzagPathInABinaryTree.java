package edu.pepcoding.tree;

public class LongestZigzagPathInABinaryTree {
  static int lp = 0;

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static class Pair{
    int leftMaxZigZagPath;
    int rightMaxZigZagPath;
    int max;

    public Pair(int leftMaxZigZagPath, int rightMaxZigZagPath, int max) {
      this.leftMaxZigZagPath = leftMaxZigZagPath;
      this.rightMaxZigZagPath = rightMaxZigZagPath;
      this.max = max;
    }
  }

  public static int longestZigZagPath(TreeNode root) {
    return traverseZigZagPath(root).max;
  }

  public static Pair traverseZigZagPath(TreeNode node) {
      if(node == null){
        return new Pair(-1,-1,0);
      }
      Pair left = traverseZigZagPath(node.left);
      Pair right = traverseZigZagPath(node.right);

      int maxAtThisNode = Math.max(left.rightMaxZigZagPath, right.leftMaxZigZagPath)+1;
      maxAtThisNode = Math.max(maxAtThisNode,Math.max(left.max, right.max));

      return new Pair(left.rightMaxZigZagPath + 1, right.leftMaxZigZagPath+1, maxAtThisNode);
  }
}
