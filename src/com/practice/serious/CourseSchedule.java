/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/8/21, 12:14 AM
 * =========================================
 */

package com.practice.serious;

import java.util.*;

public class CourseSchedule {
  public static void main(String[] args) {
    CourseSchedule me = new CourseSchedule();
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    HashMap<Integer, Integer> preqCount = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    Queue<Integer> traversal = new LinkedList<>();
    // initialize the maps
    for (int i = 0; i < numCourses; i++) {
      adjList.put(i, new ArrayList<>());
      preqCount.put(i, 0);
    }
    // build adjacency list
    for (int i = 0; i < prerequisites.length; i++) {
      int course = prerequisites[i][0], preq = prerequisites[i][1];
      adjList.get(preq).add(course);
      preqCount.put(course, preqCount.get(course) + 1);
    }

    for (Map.Entry<Integer, Integer> each : preqCount.entrySet()) {
      if (each.getValue() == 0) {
        traversal.add(each.getKey());
      }
    }
    while (!traversal.isEmpty()) {
      int node = traversal.poll();
      result.add(node);
      List<Integer> children = adjList.get(node);
      for (Integer child : children) {
        preqCount.put(child, preqCount.get(child) - 1);
        if (preqCount.get(child) == 0) traversal.add(child);
      }
    }
    if (result.size() != numCourses) return false;
    return true;
  }
}
