/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/21/21, 11:46 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PeopleIndexes {

  public static void main(String[] args) {
    PeopleIndexes me = new PeopleIndexes();
    List<List<String>> input = new ArrayList<>();
    List<String> temp = new ArrayList<String>();
    temp.add("leetcode");
    temp.add("google");
    temp.add("facebook");
    input.add(0, temp);
    temp = new ArrayList<>();
    temp.add("google");
    temp.add("microsoft");
    input.add(1, temp);
    temp = new ArrayList<>();
    temp.add("google");
    temp.add("facebook");
    input.add(2, temp);
    temp = new ArrayList<>();
    temp.add("google");
    input.add(3, temp);
    temp = new ArrayList<>();
    temp.add("amazon");
    input.add(4, temp);
    me.peopleIndexes(input);
  }

  private List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    HashMap<Integer, HashSet<String>> favourites = new HashMap<>();
    int index = 0;
    for (List<String> each : favoriteCompanies) {
      HashSet<String> userFavourite = new HashSet<>();
      favourites.put(index, userFavourite);
      for (String fav : each) {
        userFavourite.add(fav);
      }
      index++;
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < favourites.size(); i++) {
      boolean include = true;
      for (int j = 0; j < favourites.size() && include; j++) {
        if (i == j) continue;
        int favSizeA = favourites.get(i).size();
        int favSizeB = favourites.get(j).size();
        if (favSizeA > favSizeB) continue;
        int found = 0;
        HashSet<String> favA = favourites.get(i);
        HashSet<String> favB = favourites.get(j);
        for (String company : favA) {
          if (favB.contains(company)) found++;
        }
        if (found == favSizeA) {
          include = false;
          break;
        }

        // else res.add(i);
      }
      if (include) res.add(i);
    }
    return res;
  }
}
