/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/12/21, 5:56 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroConsecutive {
  public static void main(String[] args) {
    RemoveZeroConsecutive me = new RemoveZeroConsecutive();
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(-3);
    node.next.next.next.next = new ListNode(4);
    me.removeZeroSumSublists(node);
  }
  // Logic : Keep a hashmap of sums and the last Node at that sum.
  // For E.x.  A(1)->B(2)->C(3)->D(-3)->E(4) , A(1) - Node A with value 1
  // HashMap as follows
  // **  Key *** Value*****
  // **   0  *** Dummy*****
  // **   1  ***  A   *****
  // **   3  ***  B->D*****
  // **   6  ***  C   *****
  // **   7  ***  E   *****

  private ListNode removeZeroSumSublists(ListNode head) {

    Map<Integer, ListNode> map = new HashMap<>();
    ListNode dummy = new ListNode(0), p;
    dummy.next = head;
    p = dummy;
    int sum = 0;
    while (p != null) {
      sum += p.val;
      map.put(sum, p);
      p = p.next;
    }
    sum = 0;
    p = dummy;
    while (p != null) {
      sum += p.val;
      if (map.containsKey(sum)) {
        ListNode tmp = map.get(sum);
        if (tmp != p) {
          p.next = tmp.next;
        }
      }
      p = p.next;
    }
    return dummy.next;
  }
}
