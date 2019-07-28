package com.practice.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinHeight {
    public static void main(String[] args) {
        MinHeight me = new MinHeight();
        int[][] input = {};
        me.findMinHeightTrees(1, input);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges==null){
            return null;
        }
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int[] edge : edges) {

            int from = edge[0];
            int to = edge[1];
            // Create a adjacency list to hold information
            if (!adjacencyList.containsKey(from)) {
                List<Integer> neighbour = new ArrayList<>();
                neighbour.add(to);
                adjacencyList.put(from, neighbour);
            } else {
                List<Integer> neighbour = adjacencyList.get(from);
                neighbour.add(to);
                adjacencyList.put(from, neighbour);
            }
            // Make back edge
            if (!adjacencyList.containsKey(to)) {
                List<Integer> neighbour = new ArrayList<>();
                neighbour.add(from);
                adjacencyList.put(to, neighbour);
            } else {
                List<Integer> neighbour = adjacencyList.get(to);
                neighbour.add(from);
                adjacencyList.put(to, neighbour);
            }
        }
        boolean[] visited = new boolean[n];
        int minHeight = Integer.MAX_VALUE;
//        if(adjacencyList.size()==0){
//            return null;
//
//        }
        for (int i = 0; i < n; i++) {
            int height = getHeight(i, adjacencyList, visited);
            if (height < minHeight) {
                minHeight = height;
                result.clear();
                result.add(i);
            } else if (height == minHeight) {
                result.add(i);
            }
        }
        return result;
    }

    public int getHeight(int root, Map<Integer, List<Integer>> adjlist, boolean[] visited) {
        List<Integer> neighbours = adjlist.get(root);
        visited[root] = true;
        int maxHeight = 0;
        if(neighbours==null){
            return maxHeight+1;
        }
        for (Integer neighbour : neighbours) {
            if (!visited[neighbour]) {
                maxHeight = Math.max(maxHeight,getHeight(neighbour,adjlist,visited));
            }
        }
        visited[root] = false;
        return maxHeight+1;
    }
}
