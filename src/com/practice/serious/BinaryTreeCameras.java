/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/14/21, 2:49 PM
 * =========================================
 */

package com.practice.serious;

public class BinaryTreeCameras {
  public static void main(String[] args) {
    BinaryTreeCameras me = new BinaryTreeCameras();
  }
  // 0 - covered
  // 1 - needs camera
  // 2 - has Camera
  private int count = 0;

  public int minCameraCover(TreeNode root) {

    return camera(root) == 1 ? ++count : count;
    // return count;
  }

  private int camera(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = camera(root.left);
    int right = camera(root.right);

    if (left == 1 || right == 1) {
      count++;
      return 2;
    }
    if (left == 2 || right == 2) return 0;
    return 1;
  }
}
