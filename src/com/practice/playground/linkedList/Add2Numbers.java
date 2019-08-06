package com.practice.playground.linkedList;

import java.math.BigInteger;
import java.util.Stack;

// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Add2Numbers {
    public static void main(String[] args) {
        Add2Numbers me = new Add2Numbers();
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        me.addTwoNumbers(a, b);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode temp = new ListNode(1);
        ListNode result = temp;
        int carryon = 0;
        while (first != null || second != null) {
            int temp1 = 0, temp2 = 0;
            if (first != null)
                temp1 = first.val;
            if (second != null)
                temp2 = second.val;
            int sum = temp1 + temp2 + carryon;
            carryon = sum / 10;

            result.next = new ListNode(sum % 10);
            result = result.next;

            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }
        if (carryon == 1 && result != null)
            result.next = new ListNode(carryon);
        return temp.next;
    }
}
