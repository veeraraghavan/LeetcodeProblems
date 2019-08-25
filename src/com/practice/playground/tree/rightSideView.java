package com.practice.playground.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class rightSideView {
    public static void main(String[] args) {
        rightSideView me = new rightSideView();
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(3);
        input.left.right = new TreeNode(5);
        input.right.right = new TreeNode(4);
        me.rightSideView1(input);
    }

    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Stack<Integer>> result = new HashMap<>();
        traverse(root, 0, result);
        List<Integer> viewResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            viewResult.add(result.get(i).peek());
        }
        return viewResult;
    }

    public void traverse(TreeNode root, int level, HashMap<Integer, Stack<Integer>> result) {
        if (root == null)
            return;
        traverse(root.left, level + 1, result);
        if (!result.containsKey(level)) {
            result.put(level, new Stack<>());
        }
        result.get(level).push(root.val);
        traverse(root.right, level + 1, result);
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Stack<Integer>> result = new ArrayList<>();
        traverse1(root, 0, result);
        List<Integer> viewResult = new ArrayList<>();
        for (int i = result.size()-1; i>=0; i--) {
            viewResult.add(result.get(i).peek());
        }
        return viewResult;
    }

    public void traverse1(TreeNode root, int level, List<Stack<Integer>> result) {
        if (root == null)
            return;
        traverse1(root.left, level + 1, result);
        if (result.size() - 1 > level || result.size() == 0) {
            result.add(new Stack<>());
        }
        result.get(result.size()-1).push(root.val);
        traverse1(root.right, level + 1, result);
    }

}
