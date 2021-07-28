package com.practice.scribble;

import java.util.*;

public class AmazonCompetitor {
  public static void main(String[] args) {
    AmazonCompetitor me = new AmazonCompetitor();
    System.out.println(
        me.getCompetitors(
            5,
            2,
            new String[] {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"},
            3,
            new String[] {"anacell a", "betacellular b", "anacellular c"}));
  }

  private List<String> getCompetitors(
      int numCompetitor,
      int topCompetitor,
      String[] competitors,
      int numReviews,
      String[] reviews) {
    List<String> result = new ArrayList<>();
    HashMap<String, Integer> competitorCount = new HashMap<>();
    // O(C)
    for (String competitor : competitors) {
      competitorCount.putIfAbsent(competitor.toLowerCase(), 0);
    }
    String word = "";
    // O(R*W)
    for (String review : reviews) {
      word = "";
      Set<String> unique = new HashSet<>();
      for (int i = 0; i < review.length(); i++) {
        char c = review.charAt(i);
        if (Character.isLetter(c)) {
          word += Character.toLowerCase(c);
        } else {
          if (word.length() > 0) {
            if (competitorCount.containsKey(word) && !unique.contains(word)) {
              unique.add(word);
              competitorCount.put(word, competitorCount.get(word) + 1);
            }
            word = "";
          }
        }
      }
    }
    if (word.length() > 0) {
      if (competitorCount.containsKey(word)) {
        competitorCount.putIfAbsent(word, competitorCount.get(word) + 1);
      }
    }
    result = new ArrayList<>(competitorCount.keySet());
    Collections.sort(result, (a, b) -> competitorCount.get(b) - competitorCount.get(a));
    return result.subList(0, Math.min(topCompetitor, result.size()));
  }
}
