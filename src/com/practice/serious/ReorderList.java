/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/20/21, 11:02 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Stack;

public class ReorderList {
  public static void main(String[] args) {
    ReorderList me = new ReorderList();
  }

  public void reorderList(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode first = head;
    while (first != null) {
      stack.add(first);
      first = first.next;
    }
    first = head;
    while (first != null) {
      ListNode temp = first.next;
      ListNode end = stack.pop();
      end.next = temp;
      first.next = end;
      first = temp;
      if (first != null && first.next != end) {
        first.next = null;
        break;
      }
    }
  }
}
