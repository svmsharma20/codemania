package edu.pepcoding.tree;

import java.util.Scanner;

public class HouseRobberInBinaryTree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  static class Pair {
    int sumWithRobbery;
    int sumWithoutRobbery;

    public Pair(int sumWithRobbery, int sumWithoutRobbery) {
      this.sumWithRobbery = sumWithRobbery;
      this.sumWithoutRobbery = sumWithoutRobbery;
    }
  }

  public static int HouseRobber(TreeNode root) {
    Pair maxSum = getMaxSum(root);
    if (maxSum.sumWithRobbery > maxSum.sumWithoutRobbery) {
      return maxSum.sumWithRobbery;
    }
    return maxSum.sumWithoutRobbery;
  }

  public static Pair getMaxSum(TreeNode node) {
    if (node == null) {
      return new Pair(0, 0);
    }

    Pair leftSum = getMaxSum(node.left);
    Pair rightSum = getMaxSum(node.right);

    int sumWithoutRobbery = Math.max(leftSum.sumWithRobbery, leftSum.sumWithoutRobbery)
        + Math.max(rightSum.sumWithRobbery, rightSum.sumWithoutRobbery);
    int sumWithRobbery = leftSum.sumWithoutRobbery + rightSum.sumWithoutRobbery + node.val;
    return new Pair(sumWithRobbery, sumWithoutRobbery);
  }
  // input_Section_====================================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }

    TreeNode node = new TreeNode(arr[IDX[0]++]);
    node.left = createTree(arr, IDX);
    node.right = createTree(arr, IDX);

    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    System.out.println(HouseRobber(root));
  }

  public static void main(String[] args) {
    solve();
  }
}
