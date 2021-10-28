/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/26/21, 4:50 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
  public static void main(String[] args) {
    CloneGraph me = new CloneGraph();
    Node1 node1 = new Node1(1);
    Node1 node2 = new Node1(2);
    Node1 node3 = new Node1(3);
    Node1 node4 = new Node1(4);

    ArrayList<Node1> neighbors = new ArrayList<>();
    ArrayList<Node1> neighbors2 = new ArrayList<>();
    neighbors.add(node2);
    neighbors.add(node4);
    node1.neighbors = neighbors;
    node3.neighbors = neighbors;
    // neighbors.clear();
    neighbors2.add(node1);
    neighbors2.add(node3);
    node2.neighbors = neighbors2;
    node4.neighbors = neighbors2;
    me.cloneGraph(node1);
  }

  HashMap<Node1, Node1> copy = new HashMap();

  public Node1 cloneGraph(Node1 node) {
    return cloneRecurse(node);
  }

  public Node1 cloneRecurse(Node1 node) {
    if (node == null) return null;
    if (copy.containsKey(node)) {
      return copy.get(node);
    }

    copy.put(node, new Node1(node.val));
    Node1 tempNode = copy.get(node);
    for (Node1 neighbor : node.neighbors) {
      tempNode.neighbors.add(cloneRecurse(neighbor));
    }

    return tempNode;
  }
}

class Node1 {
  public int val;
  public List<Node1> neighbors;

  public Node1() {
    val = 0;
    neighbors = new ArrayList<>();
  }

  public Node1(int _val) {
    val = _val;
    neighbors = new ArrayList<Node1>();
  }

  public Node1(int _val, ArrayList<Node1> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}
