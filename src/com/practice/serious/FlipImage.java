/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/9/21, 8:50 PM
 * =========================================
 */

package com.practice.serious;

public class FlipImage {
  public static void main(String[] args) {
    FlipImage me = new FlipImage();
  }
  // https://leetcode.com/problems/flipping-an-image/
  public int[][] flipAndInvertImage(int[][] image) {

    for (int i = 0; i < image.length; i++) {
      int low = 0, high = image[i].length - 1;
      while (low <= high) {
        int temp = image[i][low];
        image[i][low] = 1 ^ image[i][high];
        image[i][high] = 1 ^ temp;

        low++;
        high--;
      }
    }

    return image;
  }
}
