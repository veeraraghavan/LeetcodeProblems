package com.practice.playground.tree;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
    public static void main(String[] args) {
        TreeNode input = new TreeNode(1);
        input.left=new TreeNode(4);
        input.right=new TreeNode(2);
        input.right.left = new TreeNode(3);
        InorderIterative me = new InorderIterative();
        me.inorderTraversal(input);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !st.empty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;

    }
}
