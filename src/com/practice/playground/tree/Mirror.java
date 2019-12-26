package com.practice.playground.tree;

import com.practice.amzn.MinStack;

import java.util.TreeSet;

public class Mirror {
    public static void main(String[] args) {
        Mirror me = new Mirror();
        TreeNode input = new TreeNode(1);
        input.left=new TreeNode(2);
        input.right=new TreeNode(2);
        input.left.right = new TreeNode(3);
        input.right.right=new TreeNode(3);
        System.out.println(me.isSymmetric(input));
    }
    public String preorder(TreeNode root,String result){
        if(root==null)
            return result;
        result+=root.val;
        // temp+=preorder(root.left,temp);
        // temp+=preorder(root.right,temp);
        return result+preorder(root.left,"")+preorder(root.right,"");
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return true;
        String left=preorder(root.left,"");
        String right=preorder_modified(root.right,"");
        return left.equals(right);

    }
    public String preorder_modified(TreeNode root,String result){
        if(root==null)
            return result;
        result+=root.val;
        // temp+=preorder_modified(root.right,temp);
        // temp+=preorder_modified(root.left,temp);
        return result + preorder_modified(root.right,"")+preorder_modified(root.left,"");
    }
}
