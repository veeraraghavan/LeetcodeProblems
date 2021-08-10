/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/9/21, 8:35 PM
 * =========================================
 */

package com.practice.serious;

public class SingleNumberIII {
  public static void main(String[] args) {
    SingleNumberIII me = new SingleNumberIII();
  }

  public int[] singleNumber(int[] nums) {
    int[] res = new int[2];
    int sum = 0;
    for (int num : nums) {
      sum ^= num;
    }
    sum = sum & (-sum);
    for (int num : nums) {
      if ((num & sum) != 0) {
        res[0] ^= num;
      } else {
        res[1] ^= num;
      }
    }
    return res;
  }
}
