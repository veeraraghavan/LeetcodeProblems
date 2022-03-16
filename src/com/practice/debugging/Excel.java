/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   2/18/22, 3:54 PM
 * =========================================
 */

package com.practice.debugging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Excel {
  int[][] cells;
  HashMap<String, HashMap<String, Integer>> references;
  HashMap<String, HashSet<String>> inclusions;
  int rows, cols;

  public Excel(int height, char width) {
    rows = height;
    cols = width - 'A' + 1;
    cells = new int[rows][cols];
    references = new HashMap();
    inclusions = new HashMap();
  }

  public void set(int row, char column, int val) {
    int col = getColumn(column);
    int oldValue = cells[row - 1][col];
    cells[row - 1][col] = val;
    int diff = val - oldValue;
    String key = getKey(row, col);
    adjustInclusionsReferences(getKey(row, col));
    updateValues(key, diff);
  }

  private void adjustInclusionsReferences(String key) {
    if (inclusions.containsKey(key)) {
      for (String ref : inclusions.get(key)) {
        references.get(ref).remove(key);
      }
      inclusions.remove(key);
    }
  }

  public int get(int row, char column) {
    int col = getColumn(column);
    return cells[row - 1][col];
  }

  public int sum(int row, char column, String[] numbers) {

    int col = getColumn(column);
    int sum = 0;
    for (String number : numbers) {
      if (!number.contains(":")) { // single cell case

        sum += cells[getRowFromKey(number)][getColFromKey(number)];
        // Trigger updation of cells
        updateRefs(number, getKey(row, col));
        // updateInclusions(getKey(row, col), number);
      } else { // combination case
        String[] cellRange = number.split(":");
        for (String cell : generateCellRange(cellRange[0], cellRange[1])) {
          sum += cells[getRowFromKey(cell)][getColFromKey(cell)];
          updateRefs(cell, getKey(row, col));
          // updateInclusions(getKey(row, col), cell);
          // Trigger updation of cells

        }
      }
    }
    int old = cells[row - 1][col];
    cells[row - 1][col] = sum;
    updateValues(getKey(row, col), sum - old);
    return sum;
  }

  private void updateValues(String key, int diff) {
    if (!references.containsKey(key)) return;
    for (String ref : references.get(key).keySet()) {
      int value = diff * references.get(key).get(ref);
      cells[getRowFromKey(ref)][getColFromKey(ref)] += value;
      updateValues(ref, value);
    }
  }

  private int getColumn(char c) {
    return c - 'A';
  }

  private void updateRefs(String key, String cell) {
    HashMap<String, Integer> dep = references.getOrDefault(key, new HashMap<>());
    dep.put(cell, dep.getOrDefault(cell, 0) + 1);
    updateInclusions(cell, key);
    references.put(key, dep);
  }

  private void updateInclusions(String key, String cell) {
    HashSet<String> inclusion = inclusions.getOrDefault(key, new HashSet<>());
    inclusion.add(cell);
    inclusions.put(key, inclusion);
  }

  private int getRowFromKey(String key) {
    return Integer.parseInt(key.substring(1)) - 1;
  }

  private int getColFromKey(String key) {
    return key.charAt(0) - 'A';
  }

  private String getKey(int row, int col) {
    char column = (char) ('A' + col);
    // row++;
    StringBuilder key = new StringBuilder();
    key.append(column).append(row);
    return key.toString();
  }

  private List<String> generateCellRange(String start, String end) {
    List<String> result = new ArrayList<>();
    int beginRow = Integer.parseInt(start.substring(1));
    int endRow = Integer.parseInt(end.substring(1));
    char beginCol = start.charAt(0);
    char endCol = end.charAt(0);
    for (int i = beginRow; i <= endRow; i++) {

      for (char j = beginCol; j <= endCol; j++) {
        StringBuilder cellRef = new StringBuilder();
        cellRef.append(j).append(i);
        result.add(cellRef.toString());
      }
    }
    return result;
  }
}

/**
 * Your Excel object will be instantiated and called as such: Excel obj = new Excel(height, width);
 * obj.set(row,column,val); int param_2 = obj.get(row,column); int param_3 =
 * obj.sum(row,column,numbers);
 */
