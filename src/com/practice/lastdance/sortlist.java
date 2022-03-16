/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   12/31/21, 11:20 AM
 * =========================================
 */

package com.practice.lastdance;

import java.util.PriorityQueue;

public class sortlist {
  public static void main(String[] args) {
    sortlist me = new sortlist();
  }

  public ListNode sortList(ListNode head) {
    ListNode temp = head;
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    while (temp != null) {
      minHeap.add(temp);
      temp = temp.next;
    }
    ListNode result = new ListNode(0);
    ListNode prev = result;

    while (!minHeap.isEmpty()) {
      prev.next = minHeap.poll();
      prev = prev.next;
    }
    prev.next = null;
    return result.next;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
