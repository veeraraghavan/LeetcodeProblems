package com.practice.leetcode.linkedList;

public class LinkedListCycleStart {
    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);
        //input.next.next.next.next.next=input;
        LinkedListCycleStart me = new LinkedListCycleStart();
        System.out.println(me.isCyclePresent(input));

    }

    public ListNode isCyclePresent(ListNode head) {
        if (head == null)
            return null;
        ListNode walker = head;
        ListNode runner = head;
        while (true) {
            if (runner.next == null)
                return null;
            runner = runner.next;
            if (runner.next == null)
                return null;
            runner = runner.next;
            walker = walker.next;
            if (walker == runner)
                break;
        }
        walker = head;
        while (true){
            if(walker==runner){
                walker.next=null;
                return walker;
            }
            walker=walker.next;
            runner = runner.next;

        }
    }
}
