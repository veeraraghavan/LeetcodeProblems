package com.practice.leetcode.tree;

public class ValidBST {
    public static void main(String[] args) {
        TreeNode input = new TreeNode(2147483647);
       // input.left = new TreeNode(1);
        ValidBST me = new ValidBST();
        System.out.println(me.isValidBST(input));
    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root,null,null);
    }
    public boolean isBST(TreeNode root, Integer min, Integer max){
        if(root==null)
            return true;
        if((max!=null && root.val >= max )|| (min!=null && root.val <= min))
            return false;
        return (isBST(root.left,min,root.val) && isBST(root.right,root.val,max));

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
