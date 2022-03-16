/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/2/22, 8:30 AM
 * =========================================
 */

package com.practice.lastdance;

import java.util.HashSet;
// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class intersectionlist {
  public static void main(String[] args) {
    intersectionlist me = new intersectionlist();
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    HashSet<ListNode> set = new HashSet();
    ListNode temp = headA;
    while (temp != null) {
      set.add(temp);
      temp = temp.next;
    }

    temp = headB;
    while (temp != null) {
      if (set.contains(temp)) {
        return temp;
      }
      temp = temp.next;
    }
    return null;
  }
}
