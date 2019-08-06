package com.practice.playground.tree;


//* Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ValidateBST {
    public static void main(String[] args) {
        ValidateBST me = new ValidateBST();
        TreeNode root = new TreeNode(2);
        root.left = (new TreeNode(1));
        root.right = new TreeNode(3);
        System.out.println(me.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return recurseTree(null, null, root);

    }

    public boolean recurseTree(Integer min, Integer max, TreeNode root) {

        if (root == null)
            return true;
        if ((max != null && root.val >= max) || (min != null && root.val <= min))
            return false;
        return recurseTree(min, root.val, root.left) && recurseTree(root.val, max, root.right);

    }
}
