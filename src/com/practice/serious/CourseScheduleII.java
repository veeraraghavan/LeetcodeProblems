/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/8/21, 2:21 PM
 * =========================================
 */

package com.practice.serious;

import java.util.*;

public class CourseScheduleII {
  public static void main(String[] args) {
    CourseScheduleII me = new CourseScheduleII();
  }

  private int cur = 0;

  public int[] findOrderAdj(int numCourses, int[][] prerequisites) {
    int vertices[] = new int[numCourses];
    HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    HashMap<Integer, Integer> incomingEdgeCount = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    ArrayList<Integer> result = new ArrayList<>();

    // Initialize the incomingedgeList and adj List
    for (int i = 0; i < numCourses; i++) {
      adjList.put(i, new ArrayList<>());
      incomingEdgeCount.put(i, 0);
    }

    // Build the adj list and incoming Edge count from prerequisites
    for (int[] edge : prerequisites) {
      int course = edge[0];
      int preq = edge[1];
      adjList.get(preq).add(course);
      incomingEdgeCount.put(course, incomingEdgeCount.get(course) + 1);
    }

    // identify the courses without preq and start the traversal from there.
    for (Map.Entry<Integer, Integer> entry : incomingEdgeCount.entrySet()) {
      if (entry.getValue() == 0) queue.add(entry.getKey());
    }
    while (!queue.isEmpty()) {
      int vertex = queue.poll();
      result.add(vertex);
      List<Integer> children = adjList.get(vertex);
      for (Integer child : children) {
        incomingEdgeCount.put(child, incomingEdgeCount.get(child) - 1);
        if (incomingEdgeCount.get(child) == 0) {
          queue.add(child);
        }
      }
    }
    if (result.size() != numCourses) return new int[] {};
    int[] order = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      order[i] = result.get(i);
    }
    return order;
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    cur = numCourses - 1;
    ArrayList[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<Integer>();
    boolean[] visited = new boolean[numCourses];
    boolean[] dp = new boolean[numCourses];
    int[] res = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      graph[prerequisites[i][1]].add(prerequisites[i][0]);
    }
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(graph, visited, i, dp, res)) {
        return new int[0];
      }
    }
    return res;
  }

  private boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] dp, int[] res) {
    if (visited[course]) return dp[course];
    else visited[course] = true;
    for (int i = 0; i < graph[course].size(); i++) {
      if (!dfs(graph, visited, (int) graph[course].get(i), dp, res)) {
        dp[course] = false;
        return false;
      }
    }
    res[cur--] = course;
    dp[course] = true;
    return true;
  }
}
