package com.practice.playground.tree;

import java.util.ArrayList;
import java.util.List;

public class Boundary {
    public static void main(String[] args) {
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> leftborder = new ArrayList<>();
        if (root == null) return leftborder;

        if (root.left != null)
            leftborder = TraverseLeft(root.left, leftborder);
        List<Integer> leaves = new ArrayList<>();
        leaves = Leaves(root, leaves);

        List<Integer> rightBorder = new ArrayList<>();
        if (root.right != null)
            TraverseRight(root.right, rightBorder);

        //Now Consolidate
        List<Integer> out = new ArrayList<>();
        out.add(root.val);

        //left
        if (leftborder.size() > 0) {
            for (int i = 0; i < leftborder.size(); i++) {
                out.add(leftborder.get(i));
            }
        }

        //Leaves
        if (leaves.size() > 0) {
            for (int i = 0; i < leaves.size(); i++) {
                if (!(out.contains(leaves.get(i))))
                    out.add(leaves.get(i));
            }
        }

        //right border
        if (rightBorder.size() > 0) {
            for (int i = 0; i < rightBorder.size(); i++) {
                if (!(out.contains(rightBorder.get(i))))
                    out.add(rightBorder.get(i));
            }
        }

        return out;

    }

    public List<Integer> TraverseLeft(TreeNode node, List<Integer> leftBorder) {

        leftBorder.add(node.val);
        if (node.left != null ) {
            return TraverseLeft(node.left, leftBorder);
        }
        return leftBorder;
    }

    public List<Integer> Leaves(TreeNode node, List<Integer> leaves) {
        if (node.left == null && node.right == null) leaves.add(node.val);
        if (node.left != null) leaves = Leaves(node.left, leaves);
        if (node.right != null) leaves = Leaves(node.right, leaves);
        return leaves;
    }

    public List<Integer> TraverseRight(TreeNode node, List<Integer> RightBorder) {
        RightBorder.add(node.val);
        if (node.right != null) {
            return TraverseRight(node.right, RightBorder);
        }
        return RightBorder;
    }

//    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        traverse(root, result, root.right == null ? false : true, root.right == null ? false : true);
//        return result;
//
//    }
//
//    public void traverse(TreeNode root, List<Integer> result, boolean isLeft, boolean rightExists) {
//        if (root == null)
//            return;
//        if (root.left != null && root.right != null) {
//
//        } else {
//            result.add(root.val);
//        }
//        traverse(root.left, result, true, root.right == null ? false : true);
//        traverse(root.right, result, false, true);
//    }
}
