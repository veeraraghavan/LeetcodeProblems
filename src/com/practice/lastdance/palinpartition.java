/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   1/2/22, 7:50 AM
 * =========================================
 */

package com.practice.lastdance;

import java.util.ArrayList;
import java.util.List;

public class palinpartition {
  public static void main(String[] args) {
    palinpartition me = new palinpartition();
  }

  public List<List<String>> partition(String s) {
    // We need a 2-D boolean array indicating if the word between index i and j is a palindrome.
    //
    List<List<String>> res = new ArrayList<>();
    dfs(0, new boolean[s.length()][s.length()], new ArrayList<>(), s, res);
    return res;
  }

  public void dfs(
      int start, boolean[][] dp, List<String> current, String s, List<List<String>> res) {
    if (start >= s.length()) {
      res.add(new ArrayList<>(current));
      return;
    }
    for (int end = start; end < s.length(); end++) {
      if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
        dp[start][end] = true;
        current.add(s.substring(start, end + 1));
        dfs(end + 1, dp, current, s, res);
        current.remove(current.size() - 1);
      }
    }
  }
}
