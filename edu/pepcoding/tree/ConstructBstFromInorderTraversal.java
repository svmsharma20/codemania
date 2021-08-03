package edu.pepcoding.tree;

//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-bst-from-inorder-traversal/ojquestion
public class ConstructBstFromInorderTraversal {

  public static class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode constructFromInOrder(int[] inOrder) {
    return buildMyTree(inOrder, 0, inOrder.length - 1);
  }

  public static TreeNode buildMyTree(int[] inOrder, int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = start + (end - start) / 2;
    TreeNode node = new TreeNode(inOrder[mid]);

    if (start == end) {
      return node;
    }

    node.left = buildMyTree(inOrder, start, mid - 1);
    node.right = buildMyTree(inOrder, mid + 1, end);

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

  public static void main(String[] args) {
    int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
    int level[]
        = new int[]{20, 8, 22, 4, 12, 10, 14};
    TreeNode node = constructFromInOrder(in);

    display(node);
  }
}
