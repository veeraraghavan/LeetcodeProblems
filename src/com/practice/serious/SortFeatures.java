/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/22/21, 11:30 PM
 * =========================================
 */

package com.practice.serious;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SortFeatures {

  public static void main(String[] args) {
    SortFeatures me = new SortFeatures();
  }

  public String[] sortFeatures(String[] features, String[] responses) {

    HashMap<String, Integer> featureIndex = new HashMap();
    HashMap<String, Integer> featureCount = new HashMap();
    PriorityQueue<String> sortedFeatures =
        new PriorityQueue(
            (a, b) -> {
              if (featureCount.get(a) != featureCount.get(b)) {
                return featureCount.get(b) - featureCount.get(a);
              } else {
                return featureIndex.get(a) - featureIndex.get(b);
              }
            });
    int index = 0;
    for (String feature : features) {
      featureIndex.put(feature, index++);
      featureCount.put(feature, 0);
    }
    for (String response : responses) {
      String[] responseWords = response.split(" ");
      HashSet<String> respList = new HashSet();
      for (String responseWord : responseWords) {
        if (featureIndex.containsKey(responseWord) && respList.add(responseWord)) {
          featureCount.put(responseWord, featureCount.getOrDefault(responseWord, 0) + 1);
        }
      }
    }

    Arrays.sort(
        features,
        (a, b) -> {
          return featureCount.get(a) == featureCount.get(b)
              ? featureIndex.get(a) - featureIndex.get(b)
              : featureCount.get(b) - featureCount.get(a);
        });
    return features;
  }
}
