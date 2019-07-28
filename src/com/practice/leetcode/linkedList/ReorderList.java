package com.practice.leetcode.linkedList;

public class ReorderList {
    public static void main(String[] args) {
        ReorderList me = new ReorderList();
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        me.reorderList(input);
        System.out.println("Came here");
    }

    public void reorderList(ListNode head) {
       if(head==null || head.next==null)
           return;
       ListNode walker=head;
       ListNode runner=head;
       while(runner.next!=null || runner.next.next!=null){
           runner=runner.next.next;
           walker=walker.next;
       }


    }
}
