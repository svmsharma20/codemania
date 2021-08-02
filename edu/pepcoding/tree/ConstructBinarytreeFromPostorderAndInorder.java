package edu.pepcoding.tree;

import java.util.HashMap;

public class ConstructBinarytreeFromPostorderAndInorder {

  static int postIdx = 0;
  static HashMap<Integer, Integer> map = new HashMap<>();

  public static class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode buildTree(int[] postorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    postIdx = postorder.length - 1;
    return buildMyTree(postorder, inorder, 0, inorder.length - 1);
  }

  public static TreeNode buildMyTree(int[] postorder, int[] inorder, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }

    TreeNode node = new TreeNode(postorder[postIdx--]);

    if (inStart == inEnd) {
      return node;
    }

    int idx = map.get(node.val);

    node.right = buildMyTree(postorder, inorder, idx + 1, inEnd);
    node.left = buildMyTree(postorder, inorder, inStart, idx - 1);

    return node;
  }

}
