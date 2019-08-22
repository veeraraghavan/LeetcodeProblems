package com.practice.leetcode.tree;


public class MaxTree {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        MaxTree me = new MaxTree();
        TreeNode result = me.constructMaximumBinaryTree(nums);
        System.out.println("Came here");
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;

        return constructRecurse(0, nums.length - 1, nums);
    }

    public TreeNode constructRecurse(int low, int high, int[] nums) {
        if (low > high)
            return null;
        int partition = getMaxIndex(nums, low, high);
        TreeNode me = new TreeNode(nums[partition]);
        me.left = constructRecurse(low, partition - 1, nums);
        me.right = constructRecurse(partition + 1, high, nums);
        return me;

    }

    public int getMaxIndex(int[] nums, int low, int high) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }

        }
        return index;
    }

}
