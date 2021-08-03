package edu.pepcoding.tree;

import java.util.HashMap;

public class ConstructBinarytreeFromLevelorderAndInorder {

  static HashMap<Integer, Integer> inMap = new HashMap<>();
  static HashMap<Integer, Integer> lvlMap = new HashMap<>();
  static HashMap<Integer, Integer> inLvlMap = new HashMap<>();

  public static class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode buildTree(int[] inorder, int[] lvlorder) {
    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
      lvlMap.put(lvlorder[i], i);
    }

    return buildMyTree(inorder, lvlorder, 0, inorder.length - 1);
  }

  public static TreeNode buildMyTree(int[] inorder, int[] lvlorder, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }
    int minIndex = Integer.MAX_VALUE;
    for (int i = inStart; i <= inEnd; i++) {
      int idx = lvlMap.get(inorder[i]);
      if (idx < minIndex) {
        minIndex = idx;
      }
    }

    TreeNode node = new TreeNode(lvlorder[minIndex]);

    if (inStart == inEnd) {
      return node;
    }

    int idx = inMap.get(node.val);
    node.left = buildMyTree(inorder, lvlorder, inStart, idx - 1);
    node.right = buildMyTree(inorder, lvlorder, idx + 1, inEnd);

    return node;
  }

  public static void display(TreeNode node) {
    if (node == null) {
      return;
    }

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);

  }

  public static void main(String args[]) {

    int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
    int level[]
        = new int[]{20, 8, 22, 4, 12, 10, 14};
    TreeNode node = buildTree(in, level);

    display(node);
  }
}
