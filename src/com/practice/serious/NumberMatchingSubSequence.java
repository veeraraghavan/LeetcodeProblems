/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/23/21, 10:40 AM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;

public class NumberMatchingSubSequence {
  public static void main(String[] args) {
    NumberMatchingSubSequence me = new NumberMatchingSubSequence();
    System.out.println(me.numMatchingSubseq("abcde", new String[] {"a", "bb", "acd", "ace"}));
  }

  private int numMatchingSubseq(String s, String[] words) {
    int result = 0;
    ArrayList<Node>[] wordList = new ArrayList[26];
    for (int i = 0; i < 26; i++) {
      wordList[i] = new ArrayList<>();
    }
    for (String word : words) {

      wordList[word.charAt(0) - 'a'].add(new Node(word));
    }
    char[] cs = s.toCharArray();
    for (char c : cs) {
      ArrayList<Node> nodeList = wordList[c - 'a'];
      wordList[c - 'a'] = new ArrayList<Node>();
      for (Node node : nodeList) {
        node.index++;
        if (node.index == node.word.length()) {
          result++;
        } else {
          wordList[node.word.charAt(node.index) - 'a'].add(node);
        }
      }
      nodeList.clear();
    }

    return result;
  }

  //  private int subSequenceCount(String s, String pattern) {
  //
  //    int dp[][] = new int[s.length() + 1][pattern.length() + 1];
  //    for (int i = 0; i < dp.length; i++) {
  //      dp[i][0] = 1;
  //    }
  //    for (int i = 1; i < dp.length; i++) {
  //      for (int j = 1; j <= pattern.length(); j++) {
  //        if (s.charAt(i - 1) == pattern.charAt(j - 1)) {
  //          dp[i][j] = dp[i - 1][j - 1];
  //        }
  //        dp[i][j] += dp[i - 1][j];
  //      }
  //    }
  //    return dp[s.length()][pattern.length()];
  //  }

  class Node {
    String word;
    int index;

    Node(String word) {
      this.word = word;
      this.index = 0;
    }
  }
}
