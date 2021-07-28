package com.practice.india;

public class EarliestInformation {
  public static void main(String[] args) {
    EarliestInformation me = new EarliestInformation();
    System.out.println(
        me.numOfMinutes(7, 6, new int[] {1, 2, 3, 4, 5, 6, -1}, new int[] {0, 6, 5, 4, 3, 2, 1}));
  }

  private Integer[] timetaken;
  int[] parent;

  private int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    timetaken = new Integer[informTime.length];
    // Arrays.fill(timetaken, -1);
    for (int i = 0; i < n; i++) {
      find(informTime, i, manager);
    }
    int max = -1;
    for (int i = 0; i < timetaken.length; i++) {
      if (timetaken[i] > max) max = timetaken[i];
    }
    return max;
  }

  public int find(int[] informTime, int employee, int[] manager) {
    if (timetaken[employee] != null) return timetaken[employee];

    if (manager[employee] != -1) {
      timetaken[employee] = informTime[employee] + find(informTime, manager[employee], manager);
    } else {
      timetaken[employee] = informTime[employee];
    }
    return timetaken[employee];
  }
}
