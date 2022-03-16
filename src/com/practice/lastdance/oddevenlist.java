/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/5/22, 9:21 AM
 * =========================================
 */

package com.practice.lastdance;

public class oddevenlist {
  public static void main(String[] args) {
    oddevenlist me = new oddevenlist();
  }

  public ListNode oddEvenList(ListNode head) {
    if (head == null) return head;
    ListNode even = head;
    ListNode odd = head.next;
    ListNode next = odd;
    while (odd != null && odd.next != null) {
      even.next = odd.next;
      even = even.next;
      odd.next = even.next;
      odd = odd.next;
    }
    even.next = next;
    return head;
  }
}
