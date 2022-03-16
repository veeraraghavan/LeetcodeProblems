/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/19/22, 2:58 PM
 * =========================================
 */

package com.practice.lastdance;

import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
  HashMap<Integer, Node> nodeMap;
  Node head, tail;
  Random rand;

  public static void main(String[] args) {
    RandomizedSet set = new RandomizedSet();

    set.insert(0);
    set.remove(0);
    set.insert(-1);
    set.remove(0);
    set.getRandom();
    set.getRandom();
    set.getRandom();
    set.getRandom();
    set.getRandom();
    set.getRandom();
    set.getRandom();
    set.getRandom();
    set.getRandom();
  }

  public RandomizedSet() {
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
    rand = new Random();
    nodeMap = new HashMap();
  }

  public boolean insert(int val) {
    if (nodeMap.containsKey(val)) {
      return false;
    }
    add(val);
    return true;
  }

  public void add(int val) {
    Node node = new Node(val);
    nodeMap.put(val, node);
    moveToHead(node);
  }

  public void moveToHead(Node node) {
    Node next = head.next;
    head.next = node;
    node.prev = head;
    next.prev = node;
    node.next = next;
  }

  public boolean remove(int val) {
    if (nodeMap.containsKey(val)) {
      Node nodeDelete = nodeMap.get(val);
      Node prev = nodeDelete.prev;
      Node next = nodeDelete.next;
      prev.next = next;
      next.prev = prev;
      nodeMap.remove(val);
      return true;
    }
    return false;
  }

  public int getRandom() {
    //    Node first = head.next;
    //    Node last = tail.prev;
    //    Node lastBut = last.prev;
    //
    //    if (first == last) return last.val;
    //
    //    head.next = last;
    //    last.next = first;
    //    last.prev = head;
    //    first.prev = last;
    //    lastBut.next = tail;
    //    tail.prev = lastBut;
    //    return last.val;
    int next = rand.nextInt(nodeMap.size());
    return (int) nodeMap.keySet().toArray()[next];
  }
}

class Node {
  int val;
  Node next;
  Node prev;

  public Node(int val) {
    this.val = val;
  }

  public Node() {}
}
