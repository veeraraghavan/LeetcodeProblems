/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/11/21, 10:16 PM
 * =========================================
 */

package com.practice.serious;

public class ReverseSubList {
  public static void main(String[] args) {
    ReverseSubList me = new ReverseSubList();
  }

  // We need 4 nodes. We need the p-1th node lets call it start.
  // We need the pth node. lets call it Tail as this is the tail of the
  // reversed sublist.
  // Curr node points to q+1 node.
  // prev points to qth node.
  // Final connections start.next = prev;
  // tail.next = cur;

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode prev = null;
    ListNode cur = head;
    for (int i = 0; i < left - 1 && cur != null; i++) {
      prev = cur;
      cur = cur.next;
    }
    ListNode start = prev; // p-1
    ListNode tail = cur; // new q
    ListNode next = null;

    for (int i = 0; i < right - left + 1 && cur != null; i++) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    if (start != null) start.next = prev;
    else head = prev;
    tail.next = cur;
    return head;
  }
}
