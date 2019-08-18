package com.practice.playground.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode input = new TreeNode(3);
        input.left = new TreeNode(9);
        input.right = new TreeNode(20);
        input.right.left = new TreeNode(15);
        input.right.right = new TreeNode(7);
        LevelOrderTraversal me = new LevelOrderTraversal();
        List<List<Integer>> result = me.levelOrder(input);
        System.out.println("Came here");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        traverseTree(root, result, 0);
        return result;

    }

    public void traverseTree(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null)
            return;
        if (result.size() - 1 < level) {
            List temp = new ArrayList();
            temp.add(root.val);
            result.add(temp);
        } else {
            result.get(level).add(root.val);
        }
        traverseTree(root.left, result, level + 1);
        traverseTree(root.right, result, level + 1);


    }

}
