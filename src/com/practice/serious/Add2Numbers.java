/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/25/21, 10:17 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Stack;

public class Add2Numbers {
  public static void main(String[] args) {
    Add2Numbers me = new Add2Numbers();
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    me.addTwoNumbers(l1, l2);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // l1 = reverse(l1);
    // l2 = reverse(l2);
    ListNode result = new ListNode(0);
    ListNode resTemp = result;
    int sum = 0, carry = 0;
    while (l1 != null && l2 != null) {
      sum = l1.val + l2.val + carry;
      carry = sum / 10;
      sum = sum % 10;
      resTemp.next = new ListNode(sum);
      resTemp = resTemp.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      sum = l1.val + carry;
      carry = sum / 10;
      sum = sum % 10;
      resTemp.next = new ListNode(sum);
      resTemp = resTemp.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      sum = l2.val + carry;
      carry = sum / 10;
      sum = sum % 10;
      resTemp.next = new ListNode(sum);
      resTemp = resTemp.next;
      l2 = l2.next;
    }
    if (carry > 0) {
      resTemp.next = new ListNode(carry);
    }
    return result.next;
  }

  public ListNode reverse(ListNode l1) {
    Stack<ListNode> stack = new Stack<>();
    while (l1 != null) {
      stack.push(l1);
      l1 = l1.next;
    }

    l1 = stack.pop();
    ListNode head = l1;
    while (!stack.empty()) {
      l1.next = stack.pop();
      l1 = l1.next;
    }
    l1.next = null;
    return head;
  }
}
