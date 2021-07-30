/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/29/21, 10:57 PM
 * =========================================
 */

package com.practice.serious;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KLargestElement {
  public static void main(String[] args) {
    KLargestElement me = new KLargestElement();
    //    [3,2,3,1,2,4,5,5,6]
    //    4
    int nums[] = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
    // me.heapify(nums, 0);
    System.out.println(me.findKthLargestHeap(nums, 4));
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> (b - a));
    for (int num : nums) {
      heap.add(num);
    }

    while (k > 1) {
      heap.poll();
      k--;
    }
    return heap.poll();
  }

  private int findKthLargestHeap(int nums[], int k) {
    int index = 0;
    int length = nums.length;
    while (index < k) {
      heapify(nums, length - 1 - index);
      int temp = nums[0];
      nums[0] = nums[length - 1 - index];
      nums[length - 1 - index] = temp;
      index++;
    }
    return nums[length - k];
  }

  private void heapify(int[] nums, int high) {
    int low = 0;
    int mid = (low + high) / 2;
    while (mid >= low) {
      int left = mid * 2 + 1;
      int right = mid * 2 + 2;
      int largest = mid;
      if (left <= high && nums[largest] < nums[left]) largest = left;
      if (right <= high && nums[largest] < nums[right]) largest = right;
      if (largest != mid) {
        int temp = nums[mid];
        nums[mid] = nums[largest];
        nums[largest] = temp;
      }
      mid--;
    }
  }
}
