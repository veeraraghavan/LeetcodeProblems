package com.practice.leetcode;

// Sorting like pack of cards

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort me = new InsertionSort();
        int[] a = {1, 34, 2, 6666, 3, 34};
        me.insertionSort(a);
        for (int i: a)
            System.out.println(i);
    }

    public void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int currentItem = a[i];
            int j;
            for (j = i; j > 0 && currentItem < a[j-1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = currentItem;
        }
    }
}
