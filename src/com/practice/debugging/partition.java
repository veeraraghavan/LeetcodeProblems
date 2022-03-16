/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/20/22, 10:02 AM
 * =========================================
 */

package com.practice.debugging;

public class partition {
  public static void main(String[] args) {
    partition me = new partition();
    int[] input = new int[] {4, 7, -2, 1, 12, 6, 3, 0};
    me.quickSort(input, 0, input.length - 1);
    for (int num : input) {
      System.out.println(num);
    }
  }

  public void quickSort(int[] arr, int low, int high) {

    if (low < high) {
      int partition = partition(arr, low, high);
      quickSort(arr, low, partition - 1);
      quickSort(arr, partition + 1, high);
    }
  }

  public int partition(int arr[], int left, int right) {
    // This divides the entire array into 4 parts . We have pointer q,j,p
    // L - elements smaller than pivot. All elements less than q
    // G - elements greater than pivot. All elements from q upto j-1.
    // U - unscanned elements. All elements from j upto p-1.
    // P - Pivot element. Usually right most. element p

    int q = left, j = left, p = right;
    while (j < right) {
      if (arr[j] <= arr[p]) {
        swap(arr, j, q);
        q++;
      }
      j++;
    }
    swap(arr, q, p);
    return q;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
