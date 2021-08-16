/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/14/21, 10:53 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class AnalyzeUserVisitPattern {
  public static void main(String[] args) {
    AnalyzeUserVisitPattern me = new AnalyzeUserVisitPattern();
    me.mostVisitedPattern(
        new String[] {"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"},
        new int[] {436363475, 710406388, 386655081, 797150921},
        new String[] {"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"});
  }
  //   username = ["ua","ua","ua","ub","ub","ub"], timestamp = [1,2,3,4,5,6], website =
  // ["a","b","a","a","b","c"]
  /*["joe","joe","joe","james","james","james","james","mary","mary","mary"],
    timestamp = [1,2,3,4,5,6,7,8,9,10],
    website = ["home","about","career","home","cart","maps","home","home","about","career"]

  */

  /*  ["zkiikgv","zkiikgv","zkiikgv","zkiikgv"]
  [436363475,710406388,386655081,797150921]
  ["wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"]*/

  private List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    HashMap<String, Integer> patternVisitor = new HashMap<>();
    PriorityQueue<String> mostVisited =
        new PriorityQueue<String>(
            (a, b) -> {
              int countA = patternVisitor.getOrDefault(a, 0);
              int countB = patternVisitor.getOrDefault(b, 0);
              if (countA == countB) {
                return a.compareTo(b);
              }
              return countB - countA;
            });

    String user = "";
    List<String> webList = new ArrayList<>();
    userTuple[] info = new userTuple[username.length];
    for (int i = 0; i < username.length; i++) {
      info[i] = new userTuple(username[i], timestamp[i], website[i]);
    }
    Arrays.sort(
        info,
        (a, b) -> {
          if (a.getUser().equals(b.getUser())) {
            return a.getVisit() - b.getVisit();
          }
          return a.getUser().compareTo(b.getUser());
        });

    for (int i = 0; i < info.length; i++) {
      if (i == 0) {
        user = info[i].getUser();
        webList.add(info[i].getWebsite());
        continue;
      } else {
        if (user.equals(info[i].getUser())) {
          webList.add(info[i].getWebsite());
          if (webList.size() == 3) {
            String sWebsite = getStringfromList(webList);
            int count = patternVisitor.getOrDefault(sWebsite, 0);
            patternVisitor.put(sWebsite, count + 1);
            mostVisited.offer(sWebsite);
            webList.remove(0);
          }
        } else {
          webList.clear();
          webList.add(info[i].getWebsite());
          user = info[i].getUser();
          ;
        }
      }
    }
    return getListfromString(mostVisited.peek());
  }

  private String getStringfromList(List<String> web) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < web.size(); i++) {
      if (i == 0) {
        res.append(web.get(i));
        continue;
      } else {
        res.append("_").append(web.get(i));
      }
    }
    return res.toString();
  }

  private List<String> getListfromString(String website) {
    return Arrays.asList(website.split("_"));
  }
}
