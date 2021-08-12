/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 10:01 PM
 * =========================================
 */

package com.practice.serious;

public class ReverseLinkedList {
  public static void main(String[] args) {
    ReverseLinkedList me = new ReverseLinkedList();
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
