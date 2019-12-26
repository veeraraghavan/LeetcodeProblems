package com.practice.scribble;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedIn {
    public static void main(String[] args){
        ReverseLinkedIn me = new ReverseLinkedIn();
        ListNode value = new ListNode(1);
        value.next = new ListNode(2);
        value.next.next = new ListNode(3);
        value.next.next.next = new ListNode(4);
        value.next.next.next.next = new ListNode(5);
        System.out.println(me.reverseList(value));

    }
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode temp = new ListNode(0);
        reverse(head, temp);
        return temp;
    }

    public ListNode reverse(ListNode head, ListNode result) {
        if (head.next == null) {
            result.val = head.val;
            return result;
        }
        result = reverse(head.next, result);
        result.next = new ListNode(head.val);
        result = result.next;
        return result;
        //PriorityQueue
    }
}
