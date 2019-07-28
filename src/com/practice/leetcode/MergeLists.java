package com.practice.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class MergeLists {
    public int[] helper;

    public static void main(String[] args) {
        MergeLists me = new MergeLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = me.merge(l1,l2);
        ListNode pointer = result;
        while(pointer !=null){
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode currA1 = l1;
        ListNode currA2 = l2;
        ListNode mergedList = null;
        ListNode pointer = null;

        while (currA1 != null && currA2 != null) {
            if (currA1.val <= currA2.val) {
                if (mergedList == null) {
                    mergedList = new ListNode(currA1.val);
                    pointer = mergedList;
                } else {
                    pointer.next = new ListNode(currA1.val);
                    pointer = pointer.next;
                }
                currA1 = currA1.next;
            } else {
                if (mergedList == null) {
                    mergedList = new ListNode(currA2.val);
                    pointer = mergedList;
                } else {
                    pointer.next = new ListNode(currA2.val);
                    pointer = pointer.next;
                }
                currA2 = currA2.next;
            }
        }
//        while (currA1 != null) {
//            if (mergedList == null) {
//                mergedList = new ListNode(currA1.val);
//                pointer = mergedList;
//            }
//            else {
//                pointer.next = new ListNode(currA1.val);
//                pointer = pointer.next;
//            }
//            currA1 = currA1.next;
//        }
//        while (currA2 != null) {
//            if (mergedList == null) {
//                mergedList = new ListNode(currA2.val);
//                pointer = mergedList;
//            }
//            else {
//                pointer.next = new ListNode(currA2.val);
//                pointer = pointer.next;
//            }
//            currA2 = currA2.next;
//        }
        if(currA1 == null){
            if(mergedList!=null) {
                pointer.next = currA2;
            }else{
                mergedList = currA2;
            }
        }
        if(currA2 == null){
            if(mergedList!=null) {
                pointer.next = currA1;
            }else{
                mergedList = currA1;
            }
        }
        return mergedList;
    }

    public ListNode mergeRecursion(ListNode l1,ListNode l2){
        return null;
    }

}
