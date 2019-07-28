package com.practice.leetcode.linkedList;

// Floyd Cycle Detection algorithm
// 2 pointer approach- One fast- 2 steps one slow - 1 pointer
// Check if they meet - If yes loop found.
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);
        //input.next.next.next.next.next=input;
        LinkedListCycle me = new LinkedListCycle();
        System.out.println(me.isCyclePresent(input));

    }

    public boolean isCyclePresent(ListNode head) {
        if (head == null)
            return false;
        ListNode walker = head;
        ListNode runner = head;
        while (true) {
            if (runner.next == null)
                return false;
            runner = runner.next;
            if (runner.next == null)
                return false;
            runner = runner.next;
            walker = walker.next;
            if (walker == runner)
                return true;
        }
    }
}
