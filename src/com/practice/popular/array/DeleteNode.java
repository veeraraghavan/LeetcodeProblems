package com.practice.popular.array;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class DeleteNode {
    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        DeleteNode me = new DeleteNode();
        System.out.println(me.removeNthFromEnd(input, 1));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode res = head;
        ListNode cur = head;
        ListNode slow = head;
        int index = 0;
        while (cur != null) {
            if (index < n) {
                index++;

            } else {
                slow = slow.next;
            }
            cur = cur.next;
        }
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return head;

    }
}
