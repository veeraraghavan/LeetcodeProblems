/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/29/21, 9:56 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.TreeMap;
// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {
  public static void main(String[] args) {
    MergeKSortedLists me = new MergeKSortedLists();
  }

  public ListNode mergeKLists(ListNode[] lists) {

    ListNode result = new ListNode(1);
    TreeMap<Integer, ArrayList<ListNode>> accumulator = new TreeMap<>();
    for (ListNode list : lists) {
      while (list != null) {
        ArrayList<ListNode> temp = accumulator.getOrDefault(list.val, new ArrayList());
        temp.add(new ListNode(list.val));
        accumulator.put(list.val, temp);
        list = list.next;
      }
    }
    ListNode tempRes = result;
    for (Integer key : accumulator.keySet()) {
      for (ListNode temp : accumulator.get(key)) {
        tempRes.next = new ListNode(temp.val);
        tempRes = tempRes.next;
      }
    }
    return result.next;
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
}
