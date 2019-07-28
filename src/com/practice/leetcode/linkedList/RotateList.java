package com.practice.leetcode.linkedList;
//https://leetcode.com/problems/rotate-list/
public class RotateList {
    public static void main(String[] args) {

        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
//        input.next.next = new ListNode(3);
//        input.next.next.next = new ListNode(4);
//        input.next.next.next.next = new ListNode(5);
        RotateList me = new RotateList();
        ListNode result = me.rotateRight(input,1);
        System.out.println("Came here");
       

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head==null) return null;

        // Let us understand the below code for example k = 4
        // and list = 10->20->30->40->50->60.
        ListNode current  = head;
        ListNode current_2 = head;
        int length = 0;
        while(current_2!=null){
            length++;
            current_2 = current_2.next;

        }
        int l = k%length;

        // current will either point to kth or NULL after this
        // loop. current will point to node 40 in the above example
        int count = 1;
        while (count < (length-l) && current !=  null)
        {
            current = current.next;
            count++;
        }

        // If current is NULL, k is greater than or equal to count
        // of nodes in linked list. Don't change the list in this case
        if (current == null)
            return null;

        // current points to kth node. Store it in a variable.
        // kthNode points to node 40 in the above example
        ListNode kthNode = current;

        // current will point to last node after this loop
        // current will point to node 60 in the above example
        while (current.next != null)
            current = current.next;

        // Change next of last node to previous head
        // Next of 60 is now changed to node 10

        current.next = head;

        // Change head to (k+1)th node
        // head is now changed to node 50
        head = kthNode.next;

        // change next of kth node to null
        kthNode.next = null;
        return head;


    }


}



class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
