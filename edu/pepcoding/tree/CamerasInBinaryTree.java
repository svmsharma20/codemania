package edu.pepcoding.tree;

public class CamerasInBinaryTree {

  public static int cameraCount = 0;

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  /*
  * State:
  *   -1 : Need of camera
  *    0 : Has camera
  *    1 : Covered by a camera
  * */
  public static int MinCamerasInBT(TreeNode root) {
    // If root asks for a camera than root have to add it itself
    if(cameraTraversal(root) == -1){
      cameraCount++;
    }
    return cameraCount;
  }

  public static int cameraTraversal(TreeNode root){
    if(root == null){
      return 1;
    }

    int lcs = cameraTraversal(root.left);
    int rcs = cameraTraversal(root.right);

    if(lcs == -1 || rcs == -1){
      cameraCount++;
      return 0;
    }else if(lcs == 0 || rcs == 0){
      return 1;
    }else {
      return -1;
    }
  }
}