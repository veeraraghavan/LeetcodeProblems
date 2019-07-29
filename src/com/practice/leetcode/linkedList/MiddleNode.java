package com.practice.leetcode.linkedList;

//https://leetcode.com/problems/middle-of-the-linked-list/submissions/
public class MiddleNode {
    public static void main(String[] args) {

        MiddleNode me = new MiddleNode();
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);
        input.next.next.next.next.next = new ListNode(6);
        me.middleNode(input);
    }

    public ListNode middleNode(ListNode head) {

        if (head ==null)return null;

        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int mid = (count / 2)+1 ;
        curr = head;
        while (mid > 1) {
            mid--;
            curr = curr.next;
        }

        return curr;

    }
}
