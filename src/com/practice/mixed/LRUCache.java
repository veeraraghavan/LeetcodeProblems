/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/28/21, 10:01 PM
 * =========================================
 */

package com.practice.mixed;

import java.util.HashMap;

public class LRUCache {

  HashMap<Integer, DoubleLinkedList> cache = new HashMap<>();
  DoubleLinkedList head;
  DoubleLinkedList tail;
  int capacity = 0;
  int size = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new DoubleLinkedList();
    tail = new DoubleLinkedList();
    head.next = tail;
    tail.prev = head;
  }

  private void addHead(DoubleLinkedList node) {
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    node.prev = head;
  }

  private void removeNode(DoubleLinkedList node) {
    DoubleLinkedList prev = node.prev;
    DoubleLinkedList next = node.next;
    prev.next = node.next;
    next.prev = node.prev;
  }

  private void moveToHead(DoubleLinkedList node) {
    removeNode(node);
    addHead(node);
  }

  public int get(int key) {
    DoubleLinkedList node = cache.get(key);
    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value; // Need to move the node to the top
  }

  private DoubleLinkedList popTail() {
    DoubleLinkedList node = tail.prev;
    removeNode(node);
    return node;
  }

  public void put(int key, int value) {
    DoubleLinkedList node = cache.get(key);
    if (node != null) {
      node.value = value;
      moveToHead(node);
    } else {
      node = new DoubleLinkedList();
      node.value = value;
      node.key = key;
      cache.put(key, node);
      this.size++;
      addHead(node);
      if (size > capacity) {
        DoubleLinkedList removal = popTail();
        cache.remove(removal.key);
        size--;
      }
    }
  }
}

class DoubleLinkedList {
  public int key;
  public int value;
  public DoubleLinkedList prev;
  public DoubleLinkedList next;
}
