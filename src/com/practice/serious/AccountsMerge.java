/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/26/21, 6:27 PM
 * =========================================
 */

package com.practice.serious;

import java.util.*;

public class AccountsMerge {
  public static void main(String[] args) {
    AccountsMerge me = new AccountsMerge();
  }

  HashMap<String, String> emailMap;
  HashMap<String, List<String>> adjList;
  // List<List<String>> result = new ArrayList<>();

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    emailMap = new HashMap<>();
    adjList = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    buildAdj(accounts);
    HashSet<String> visited = new HashSet<>();
    for (String email : emailMap.keySet()) {
      if (visited.contains(email)) {
        List<String> account = new ArrayList<>();
        account.add(emailMap.get(email));
        List<String> emails = new ArrayList<>();
        dfs(email, visited, emails);
        Collections.sort(emails);
        account.addAll(emails);
        result.add(account);
      }
    }
    return result;
  }

  private void dfs(String email, HashSet<String> visited, List<String> emails) {
    if (visited.contains(email)) return;
    visited.add(email);
    emails.add(email);
    List<String> connected = adjList.get(email);
    for (String con : connected) {
      dfs(con, visited, emails);
    }
  }

  public void buildAdj(List<List<String>> accounts) {
    for (List<String> account : accounts) {
      String name = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        emailMap.put(email, name);
        adjList.putIfAbsent(email, new ArrayList<>());
        if (i > 1) {
          adjList.get(email).add(account.get(i - 1));
          adjList.get(account.get(i - 1)).add(email);
        }
      }
    }
  }
}
