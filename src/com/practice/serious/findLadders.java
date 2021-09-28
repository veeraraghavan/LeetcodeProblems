/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/25/21, 7:45 PM
 * =========================================
 */

package com.practice.serious;

import java.util.*;

public class findLadders {

  public static void main(String[] args) {
    findLadders me = new findLadders();
    me.findLadders(
        "hit", "cog", Arrays.asList(new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
  }

  private List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    // HashSet<String> unvisited = new HashSet<>(wordList);
    HashMap<String, List<String>> graph = new HashMap<>();
    HashMap<String, Integer> distances = new HashMap<>();
    bfs(beginWord, graph, distances, wordList);
    dfs(beginWord, endWord, graph, distances, new ArrayList<>(), result);
    return result;
  }

  private void bfs(
      String beginWord,
      HashMap<String, List<String>> graph,
      HashMap<String, Integer> distances,
      List<String> wordList) {

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    distances.put(beginWord, 1);
    while (!queue.isEmpty()) {
      String nextWord = queue.poll();
      int curDistance = distances.get(nextWord);
      graph.put(nextWord, new ArrayList<>());
      for (String n : getNeighbours(nextWord, wordList)) {
        graph.get(nextWord).add(n);
        if (!distances.containsKey(n)) {
          distances.put(n, curDistance + 1);
          queue.offer(n);
        }
      }
    }
  }

  private List<String> getNeighbours(String word, List<String> wordList) {
    List<String> neighbours = new ArrayList<>();
    char[] cword = word.toCharArray();
    for (int i = 0; i < cword.length; i++) {
      char original = cword[i];
      for (char c = 'a'; c <= 'z'; c++) {
        cword[i] = c;
        if (original == cword[i]) continue;
        String transformed = new String(cword);
        if (wordList.contains(transformed)) {
          neighbours.add(transformed);
        }
      }
      cword[i] = original;
    }
    return neighbours;
  }

  private void dfs(
      String beginWord,
      String endWord,
      HashMap<String, List<String>> graph,
      HashMap<String, Integer> distances,
      List<String> path,
      List<List<String>> paths) {
    if (beginWord.equals(endWord)) {
      List<String> temp = new ArrayList<>(path);
      temp.add(endWord);
      paths.add(temp);
      return;
    }
    path.add(beginWord);
    int distance = distances.get(beginWord);
    for (String next : graph.get(beginWord)) {
      if (distances.get(next) == distance + 1) {
        dfs(next, endWord, graph, distances, path, paths);
      }
    }
    path.remove(path.size() - 1);
  }
}
