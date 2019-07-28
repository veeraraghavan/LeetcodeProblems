package com.practice.leetcode.linkedList;

//https://leetcode.com/problems/rotate-list/
public class OddEvenSplit {
    public static void main(String[] args) {

        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);
        OddEvenSplit me = new OddEvenSplit();
        me.SplitList(input);
        System.out.println("Came here");
    }

    public ListNode SplitList(ListNode root) {

        return null;
    }
}


