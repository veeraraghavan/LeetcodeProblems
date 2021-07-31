/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/31/21, 6:50 AM
 * =========================================
 */

package com.practice.serious;

public class RemoveNthNode {
  public static void main(String[] args) {
    RemoveNthNode me = new RemoveNthNode();
    ListNode one = new ListNode(1);
    one.next = new ListNode(2);
    one.next.next = new ListNode(3);
    one.next.next.next = new ListNode(4);
    one.next.next.next.next = new ListNode(5);
    me.removeNthFromEnd(one, 2);
  }

  private ListNode removeNthFromEnd(ListNode head, int n) {

    int count = 0;
    ListNode temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    // 0->1->2->3->4->5->6->7->9 count = 9, n=7
    int eleToDelete = count - n;
    ListNode prev = null;
    temp = head;
    if (eleToDelete == 0) return head.next;
    int index = 0;
    while (index < eleToDelete) {
      prev = temp;
      temp = temp.next;
      index++;
    }
    prev.next = temp.next;
    return head;
  }
}
