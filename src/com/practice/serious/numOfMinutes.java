/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/15/21, 11:12 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class numOfMinutes {

  public static void main(String[] args) {
    numOfMinutes me = new numOfMinutes();
    System.out.println(
        me.numOfMinutes(7, 6, new int[] {1, 2, 3, 4, 5, 6, -1}, new int[] {0, 6, 5, 4, 3, 2, 1}));
  }

  private int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    HashMap<Integer, ArrayList<Integer>> hierarchy = new HashMap<>();
    hierarchy.put(headID, new ArrayList<>());
    Queue<Integer> mgr = new LinkedList<>();
    mgr.offer(headID);

    for (int i = 0; i < manager.length; i++) {
      if (i == headID) continue;
      ArrayList<Integer> employees = hierarchy.getOrDefault(manager[i], new ArrayList<>());
      employees.add(i);
      hierarchy.put(manager[i], employees);
    }

    int totalMin = 0;
    while (!mgr.isEmpty()) {
      int size = mgr.size();
      int maxLevel = 0;
      for (int i = 0; i < size; i++) {
        int currMgr = mgr.peek();
        maxLevel = Math.max(maxLevel, informTime[currMgr]);
        ArrayList<Integer> employees = hierarchy.get(currMgr);
        if (hierarchy.containsKey(currMgr)) {
          mgr.addAll(hierarchy.get(currMgr));
        }
        mgr.poll();
      }
      totalMin += maxLevel;
    }
    return totalMin;
  }
}
