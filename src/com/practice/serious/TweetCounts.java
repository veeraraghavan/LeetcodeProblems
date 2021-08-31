/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/30/21, 5:02 PM
 * =========================================
 */

package com.practice.serious;

import java.util.*;

public class TweetCounts {
  public static void main(String[] args) {
    TweetCounts me = new TweetCounts();
    me.recordTweet("tweet3", 0);
    me.recordTweet("tweet3", 60);
    me.recordTweet("tweet3", 10);
    me.getTweetCountsPerFrequency("minute", "tweet3", 0, 59);
    me.getTweetCountsPerFrequency("minute", "tweet3", 0, 60);
    me.recordTweet("tweet3", 120);
    me.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);
  }

  HashMap<String, TreeMap<Integer, Integer>> tweets;

  public TweetCounts() {
    tweets = new HashMap<>();
  }

  public void recordTweet(String tweetName, int time) {
    if (!tweets.containsKey(tweetName)) {
      tweets.put(tweetName, new TreeMap<>());
    }
    TreeMap<Integer, Integer> map = tweets.get(tweetName);
    map.put(time, map.getOrDefault(time, 0) + 1);
  }

  public List<Integer> getTweetCountsPerFrequency(
      String freq, String tweetName, int startTime, int endTime) {
    List<Integer> result = new ArrayList<>();
    int partition = 0;
    switch (freq) {
      case "minute":
        partition = 60;
        break;
      case "hour":
        partition = 3600;
        break;
      case "day":
        partition = 86400;
        break;
    }
    int buckets = (endTime - startTime) / partition + 1;
    if (!tweets.containsKey(tweetName)) return null;
    TreeMap<Integer, Integer> map = tweets.get(tweetName);
    int[] count = new int[buckets];
    for (Map.Entry<Integer, Integer> entry : map.subMap(startTime, endTime + 1).entrySet()) {
      int key = entry.getKey();
      int index = ((key - startTime) / partition);
      count[index] += entry.getValue();
    }
    for (int num : count) {
      result.add(num);
    }
    return result;
  }
}
