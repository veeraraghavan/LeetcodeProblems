package com.practice.leetcode;

public class QuickSort {

  public static void main(String[] args) {
    int[] a = {1, 3, 2, 8, 6, 7};
    QuickSort me = new QuickSort();
    me.quickSort(a, 0, a.length - 1);
    for (int k : a) {
      System.out.println(k);
    }
  }

  private void quickSort(int[] a, int low, int high) {
    if (low < high) {
      int pivot = partition(a, low, high);
      quickSort(a, low, pivot - 1);
      quickSort(a, pivot + 1, high);
    }
  }

  private int partition(int[] array, int p, int r) {
    int q = p, j = p;
    while (j < r) {
      if (array[j] <= array[r]) {
        swap(array, j, q);
        j++;
        q++;
      } else {
        j++;
      }
    }
    /*
    1,4,5,2,3
    4,5,1,2,3
    4,3,1,2,5




    */
    swap(array, q, r); // Why does this swap happen
    System.out.println("p:" + p + "  q:" + q + "  pivot:" + (q - 1));
    // System.out.println()
    return q;
  }

  private void swap(int[] array, int firstIndex, int secondIndex) {
    int temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
  }
  ;
}
