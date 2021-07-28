package com.practice.leetcode.array;

// https://leetcode.com/problems/find-the-duplicate-number/
public class MissingPositive {
  public static void main(String[] args) {
    MissingPositive me = new MissingPositive();
    int[] nums = {1, 7, 3, 4};
    // System.out.println(me.firstMissingPositive(nums));
    System.out.println(me.firstMissingPositive1(nums));
  }

  private int firstMissingPositive1(int[] arr) {
    boolean oneExists = false;
    for (int x : arr) {
      if (x == 1) oneExists = true;
    }
    if (!oneExists) return 1;
    if (arr.length == 1) return 2;
    // Assign 1's to all number that are negative or greater than the value
    // of length of array
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > arr.length || arr[i] <= 0) arr[i] = 1;
    }
    // Check if there is a value (length of array) in array. If yes, set the 0th element to negative
    // Else set number to negative
    for (int i = 0; i < arr.length; i++) {
      int a = Math.abs(arr[i]);
      if (a == arr.length) arr[0] = -Math.abs(arr[0]);
      else arr[a] = -Math.abs(arr[a]);
    }
    /*
     1,3,4,5,6
     1,3,4,5,1
     -1,-3,4,-5,-6
    */
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > 0) return i;
    }
    if (arr[0] > 0) return arr.length;

    return arr.length + 1;
  }

  public int MissingPositive(int[] arr) {
    int splitIndex = SplitArray(arr);
    int[] newNums = new int[arr.length - splitIndex];
    for (int i = 0; i < arr.length - splitIndex; i++) {
      newNums[i] = arr[splitIndex + i];
    }
    for (int i = 0; i < newNums.length; i++) {
      int x = Math.abs(newNums[i]);
      if (x - 1 < newNums.length && newNums[x - 1] > 0) {
        newNums[x - 1] = -newNums[x - 1];
      }
    }
    int j = 0;
    for (j = 0; j < newNums.length; j++) {
      if (newNums[j] > 0) return j + 1;
    }
    return newNums.length + 1;
  }

  private int SplitArray(int[] nums) {
    int i = 0;
    int temp = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] <= 0) {
        temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        i++;
      }
    }
    return i;
  }

  public int firstMissingPositive(int[] arr) {
    int shift = segregate(arr, arr.length);
    int arr2[] = new int[arr.length - shift];
    int j = 0;
    for (int i = shift; i < arr.length; i++) {
      arr2[j] = arr[i];
      j++;
    }
    // Shift the array and call
    // findMissingPositive for
    // positive part
    return findMissingPositive(arr2, j);
  }

  private int segregate(int arr[], int size) {
    int j = 0, i;
    for (i = 0; i < size; i++) {
      if (arr[i] <= 0) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // increment count of non-positive
        // integers
        j++;
      }
    }

    return j;
  }

  /* Find the smallest positive missing
  number in an array that contains
  all positive integers */
  private int findMissingPositive(int arr[], int size) {
    int i;

    // Mark arr[i] as visited by making
    // arr[arr[i] - 1] negative. Note that
    // 1 is subtracted because index start
    // from 0 and positive numbers start from 1
    for (i = 0; i < size; i++) {
      int x = Math.abs(arr[i]);
      if (x - 1 < size && arr[x - 1] > 0) arr[x - 1] = -arr[x - 1];
    }

    // Return the first index value at which
    // is positive
    for (i = 0; i < size; i++) if (arr[i] > 0) return i + 1; // 1 is added becuase indexes
    // start from 0

    return size + 1;
  }
}
