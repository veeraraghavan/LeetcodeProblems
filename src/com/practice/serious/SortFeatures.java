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

public class SortFeatures {

  public static void main(String[] args) {
    SortFeatures me = new SortFeatures();
    System.out.println(me.sortFeatures(new String[] {""}, new String[] {""}).length);
  }

  private String[] sortFeatures(String[] features, String[] responses) {

    HashMap<String, Integer> featureIndex = new HashMap<>();
    HashMap<String, Integer> featureCount = new HashMap<>();
    int index = 0;
    for (String feature : features) {
      featureIndex.put(feature, index++);
      featureCount.put(feature, 0);
    }
    for (String response : responses) {
      String[] responseWords = response.split(" ");
      HashSet<String> respList = new HashSet<>();
      for (String responseWord : responseWords) {
        if (featureIndex.containsKey(responseWord) && respList.add(responseWord)) {
          featureCount.put(responseWord, featureCount.getOrDefault(responseWord, 0) + 1);
        }
      }
    }

    Arrays.sort(
        features,
        (a, b) ->
            featureCount.get(a).equals(featureCount.get(b))
                ? featureIndex.get(a) - featureIndex.get(b)
                : featureCount.get(b) - featureCount.get(a));
    return features;
  }
}
