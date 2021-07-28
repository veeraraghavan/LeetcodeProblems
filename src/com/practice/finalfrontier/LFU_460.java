/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   6/3/21, 8:36 AM
 * =========================================
 */

package com.practice.finalfrontier;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFU_460 {
  public static void main(String[] args) {
    LFU_460 me = new LFU_460(0);
  }

  private HashMap<Integer, Integer> valueStore;
  private HashMap<Integer, Integer> occurence;
  private HashMap<Integer, LinkedHashSet<Integer>> frequencyList;
  private int capacity = 0;
  private int minimum = -1;

  private LFU_460(int capacity) {
    if (capacity > 0) {
      this.capacity = capacity;
      valueStore = new HashMap();
      occurence = new HashMap();
      frequencyList = new HashMap();
      frequencyList.put(1, new LinkedHashSet());
    }
  }

  // Important rules
  // Every get increases the occurrence. Drops the key from occurrence list and adds it to new
  // occurrence list.
  // Why do we need to keep track of minimum . When deletion from cache, need to delete entry from
  // everywhere
  public int get(int key) {
    if (capacity <= 0) return -1;
    if (!valueStore.containsKey(key)) return -1; // Return -1 if key not found
    // if key is found, get the occurrence and increment the count
    int count = occurence.get(key);
    occurence.put(key, count + 1);
    frequencyList.get(count).remove(key);
    if (!frequencyList.containsKey(count + 1)) frequencyList.put(count + 1, new LinkedHashSet());
    frequencyList.get(count + 1).add(key);
    if (count == minimum && frequencyList.get(count).size() == 0) minimum++;
    return valueStore.get(key);
  }

  public void put(int key, int value) {
    if (capacity <= 0) return;
    if (valueStore.containsKey(key)) {
      valueStore.put(key, value);
      get(key);
      return;
    } else {
      if (capacity
          == valueStore
              .size()) { // time to drop the least frequently used value from all the lists, map
        int eleToRemove = frequencyList.get(minimum).iterator().next();
        frequencyList.get(minimum).remove(eleToRemove);
        valueStore.remove(eleToRemove);
      }
      valueStore.put(key, value);
      occurence.put(key, 1);
      minimum = 1;
      frequencyList.get(minimum).add(key);
    }
  }
}
