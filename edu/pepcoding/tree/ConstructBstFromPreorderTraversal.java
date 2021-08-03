package edu.pepcoding.tree;

import edu.pepcoding.tree.model.TreeNode;
import java.util.HashMap;
import java.util.Stack;

public class ConstructBstFromPreorderTraversal {

  // next greater element index
  static HashMap<Integer, Integer> nextGEI = new HashMap<>();

  public static TreeNode bstFromPreorder(int[] preorder) {
    initNextGEI(preorder);
    return buildMyTree(preorder, 0, preorder.length - 1);
  }

  public static TreeNode buildMyTree(int[] preorder, int start, int end) {
    if (start > end || start == -1) {
      return null;
    }

    TreeNode node = new TreeNode(preorder[start]);

    if (start == end) {
      return node;
    }

    int idx = nextGEI.get(node.val);
    if (idx == -1) {
      node.left = buildMyTree(preorder, start + 1, end);
    } else {
      node.left = buildMyTree(preorder, start + 1, idx - 1);
      node.right = buildMyTree(preorder, idx, end);
    }

    return node;
  }

  public static void initNextGEI(int[] arr) {
    Stack<Integer> stack = new Stack<>();

    for (int i = arr.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nextGEI.put(arr[i], -1);
      } else {
        nextGEI.put(arr[i], stack.peek());
      }
      stack.push(i);
    }
  }
}
