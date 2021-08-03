/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/2/21, 10:34 PM
 * =========================================
 */

package com.practice.serious;

class TrieNode {

  private boolean isEnd;
  private TrieNode[] links;
  private int length = 26;

  TrieNode() {
    links = new TrieNode[length];
  }

  void setEnd() {
    isEnd = true;
  }

  public TrieNode get(char ch) {
    return links[ch - 'a'];
  }

  public boolean containsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  public void put(char ch, TrieNode node) {
    links[ch - 'a'] = node;
  }

  public boolean isEnd() {
    return isEnd;
  }
}
