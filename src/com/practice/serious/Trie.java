/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/2/21, 10:20 PM
 * =========================================
 */

package com.practice.serious;

public class Trie {
  public TrieNode root;

  private Trie() {
    root = new TrieNode();
  }

  public static void main(String[] args) {
    Trie me = new Trie();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.containsKey(ch)) {
        node.put(ch, new TrieNode());
      }
      node = node.get(ch);
    }
    node.setEnd();
  }

  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  private TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (node.containsKey(ch)) {
        node = node.get(ch);
      } else {
        return null;
      }
    }
    return node;
  }

  public boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }
}
