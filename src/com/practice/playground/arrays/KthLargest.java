package com.practice.playground.arrays;

public class KthLargest {
    public static void main(String[] args) {
        int[] input = {3, 2, 1, 5, 6, 4};
        KthLargest me = new KthLargest();
        System.out.println(me.findKthLargest(input, 2));
        input = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(me.findKthLargest(input,4));
        input = new int[]{3,1,2,4};
        System.out.println(me.findKthLargest(input,2));
    }

    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        int i = 0;
        while (i < k) {
            heapify(nums, nums.length - i-1);
            result = nums[0];
            int temp = nums[0];
            nums[0] = nums[nums.length - i-1];
            nums[nums.length - i-1] = temp;
            i++;

        }
        return result;

    }

    public void heapify(int[] arr, int n) {
        int i = (n / 2);
        while (i >= 0) {
            int temp = 0;
            if ((((2 * i) + 1) <= n) && arr[i] < arr[(2 * i + 1)]) {
                temp = (2 * i) + 1;
            } else {
                temp = i;
            }
            if ((((2 * i) + 2) <= n) && arr[temp] < arr[(2 * i) + 2]) {
                temp = (2 * i) + 2;
            }
            if (i != temp) {
                int temporary = arr[temp];
                arr[temp] = arr[i];
                arr[i] = temporary;
            }
            i--;
        }
        return;

    }
}
