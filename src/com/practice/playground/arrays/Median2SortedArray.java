package com.practice.playground.arrays;

public class Median2SortedArray {
    public static void main(String[] args) {
        Median2SortedArray me = new Median2SortedArray();
        int[] a = {1, 2};
        int[] b = {3, 4,5,6,7,8,9,10};
        System.out.println(me.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = nums1.length, partitionX, partitionY, maxleftX, maxleftY, minRightX, minRightY;
        while (low <= high) {
            partitionX = (low + high) / 2;
            partitionY = ((nums1.length + nums2.length + 1) / 2) - partitionX;
            maxleftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            minRightX = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
            maxleftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            minRightY = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxleftX <= minRightY && maxleftY <= minRightX) {
                if ((nums1.length + nums2.length) % 2 == 0)
                    return ((double)(Math.max(maxleftX, maxleftY) + Math.min(minRightX, minRightY)) / 2);
                return Math.max(maxleftX, maxleftY);
            } else if (maxleftX > minRightY) {
                high = partitionX - 1;

            } else {
                low = partitionX + 1;
            }
        }

        return 0;

    }
}
