/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/3/21, 8:19 AM
 * =========================================
 */

package com.practice.serious;

import java.util.HashMap;
import java.util.List;

public class WordSearchII {
  private TrieNodes root;
  private List<String> _result;
  private char[][] _board = null;

  public static void main(String[] args) {
    WordSearchII me = new WordSearchII();
  }

  public List<String> findWords(char[][] board, String[] words) {
    createTrie(words);
    this._board = board;
    int row = board.length;
    int col = board[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (root.children.containsKey(board[i][j])) {
          dfs(i, j, root);
        }
      }
    }
    return this._result;
  }

  private void dfs(int i, int j, TrieNodes parentNode) {
    char letter = _board[i][j];
    TrieNodes currentNode = parentNode.children.get(letter);
    if (currentNode.word != null) {
      this._result.add(currentNode.word);
      currentNode.word = null;
    }

    _board[i][j] = '#';
    int[] rowOffset = new int[] {-1, 0, 1, 0};
    int[] colOffset = new int[] {0, 1, 0, -1};
    for (int index = 0; index < 4; index++) {
      int newRow = i + rowOffset[index];
      int newCol = j + colOffset[index];
      if (newRow < 0 || newRow >= _board.length || newCol < 0 || newCol >= _board[0].length)
        continue;
      if (currentNode.children.containsKey(_board[newRow][newCol]))
        dfs(newRow, newCol, currentNode);
    }
    _board[i][j] = letter;
    if (currentNode.children.isEmpty()) {
      parentNode.children.remove(letter);
    }

    //      if(next

  }

  private void createTrie(String[] words) {
    root = new TrieNodes();
    for (String word : words) {
      TrieNodes currentNode = root;
      for (char c : word.toCharArray()) {
        if (!currentNode.children.containsKey(c)) {
          currentNode.children.put(c, new TrieNodes());
        }
        currentNode = currentNode.children.get(c);
      }
      currentNode.word = word;
    }
  }
}

class TrieNodes {
  HashMap<Character, TrieNodes> children = new HashMap<>();
  String word;

  TrieNodes() {}
}
