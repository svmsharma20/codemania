package edu.pepcoding.tree;

import edu.pepcoding.tree.model.TreeNode;
import java.util.HashMap;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-binarytree-from-preorder-and-inorder-traversal/ojquestion
public class ConstructBinarytreeFromPreorderAndInorder {

  static int preIndex = 0;
  static HashMap<Integer, Integer> map = new HashMap<>();

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return buildMyTree(preorder, inorder, 0, preorder.length-1);
  }

  public static TreeNode buildMyTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
    if(inStart > inEnd){
      return null;
    }

    TreeNode node = new TreeNode(preorder[preIndex++]);

    if(inStart == inEnd){
      return node;
    }

    int idx = map.get(node.val);

    node.left = buildMyTree(preorder, inorder, inStart, idx-1);
    node.right = buildMyTree(preorder, inorder, idx+1, inEnd);

    return node;
  }
}
