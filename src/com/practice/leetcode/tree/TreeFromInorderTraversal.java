package com.practice.leetcode.tree;

public class TreeFromInorderTraversal {
    public static void main(String[] args) {
//        int [] traversal = {5,2,1,3};
//        TreeFromInorderTraversal me = new TreeFromInorderTraversal();
//        Node result = me.constructBSTfromArray(traversal);
//
        int[] preOrder = {5,2,1,7};
        TreeFromInorderTraversal p = new TreeFromInorderTraversal();
        Node result = p.constructTree(preOrder, preOrder[0], Integer.MIN_VALUE,
                Integer.MAX_VALUE);
        System.out.println("Here");

    }

    int pIndex = 0;

    public TreeFromInorderTraversal() {

    }

    public Node constructBSTfromArray(int[] array) {
        if (array.length == 0)
            return null;

        int[] preOrder = {20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40};
        TreeFromInorderTraversal p = new TreeFromInorderTraversal();
        return p.constructTree(preOrder, preOrder[0], Integer.MIN_VALUE,
                Integer.MAX_VALUE);


    }

    public void constructWithRecurse(Node node, int index, int[] array, int max) {
        if (index == array.length)
            return;
        if (array[index] < node.key) {
            node.left = new Node(array[index]);
            constructWithRecurse(node.left, index + 1, array, node.key);
        }
        if (array[index] < max) {
            node.right = new Node(array[index]);
            constructWithRecurse(node.right, index + 1, array, node.key);
        }
        return;
    }

    public Node constructTree(int[] preorder, int data, int min, int max) {
//        if(pIndex<array.length){
//            if(array[pIndex] >= min && array[pIndex] <= max){
//                Node root = new Node(data);
//                pIndex++;
//                if(pIndex < array.length){
//                    root.left = constructWithRecurse2(array,array[pIndex],min,data);
//                    root.right = constructWithRecurse2(array,array[pIndex],data,max);
//                }
//                return root;
//            }
//        }
//        return null;
        if (pIndex < preorder.length) {
            if (preorder[pIndex] > min && preorder[pIndex] < max) {
                Node root = new Node(data);
                pIndex++;
                if (pIndex < preorder.length) {
                    // nodes lies between min and data will create left subtree
                    root.left = constructTree(preorder, preorder[pIndex], min,
                            data);
                    // nodes lies between data and max will create right subtree
                    root.right = constructTree(preorder, preorder[pIndex],
                            data, max);
                }
                return root;
            }
        }
        return null;
    }
}

class Node {
    int key;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
    }
}
