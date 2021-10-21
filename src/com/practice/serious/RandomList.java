/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/20/21, 10:43 PM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;

public class RandomList {
  public static void main(String[] args) {
    RandomList me = new RandomList();
  }

  HashMap<NodeRandom, NodeRandom> map = new HashMap<>();

  public NodeRandom copyRandomList(NodeRandom head) {
    if (head == null) return null;
    if (map.containsKey(head)) {
      return map.get(head);
    }
    NodeRandom node = new NodeRandom(head.val, null, null);
    map.put(head, node);
    node.next = copyRandomList(head.next);
    node.random = copyRandomList(head.random);
    return node;
  }
}

class NodeRandom {
  int val;
  NodeRandom next;
  NodeRandom random;

  public NodeRandom(int val, NodeRandom next, NodeRandom random) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}
