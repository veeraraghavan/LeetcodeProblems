/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/29/21, 12:37 PM
 * =========================================
 */

package com.practice.serious;

public class MRUQueue {
  public static void main(String[] args) {
    MRUQueue me = new MRUQueue(8);
  }

  // HashMap<Integer, DoubleLinkedList> nodes;
  DoubleLinkedList head;
  DoubleLinkedList tail;

  private void moveToTail(DoubleLinkedList node) {
    deleteNode(node);
    addToTail(node);
  }

  private void deleteNode(DoubleLinkedList node) {
    DoubleLinkedList prev = node.prev;
    DoubleLinkedList next = node.next;
    prev.next = next;
    next.prev = prev;
  }

  private void addToTail(DoubleLinkedList node) {
    DoubleLinkedList prev = tail.prev;
    prev.next = node;
    node.prev = prev;
    node.next = tail;
    tail.prev = node;
  }

  public MRUQueue(int n) {
    head = new DoubleLinkedList();
    tail = new DoubleLinkedList();
    head.next = tail;
    tail.prev = head;
    // nodes = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      DoubleLinkedList node = new DoubleLinkedList();
      node.value = i;
      addToTail(node);
      // nodes.put(i, node);
    }
  }

  public DoubleLinkedList getNthNode(int k) {
    DoubleLinkedList temp = head;
    for (int i = 1; i <= k; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public int fetch(int k) {
    DoubleLinkedList node = getNthNode(k);
    moveToTail(node);
    return node.value;
  }
}

class DoubleLinkedList {
  public int key;
  public int value;
  public DoubleLinkedList prev;
  public DoubleLinkedList next;
}
