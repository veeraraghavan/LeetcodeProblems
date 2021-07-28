/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   11/2/20, 2:03 PM
 * =========================================
 */

package com.practice.grokprog.subsets;

import java.util.ArrayList;
import java.util.List;

public class Abbreviation {
  public static void main(String[] args) {
    Abbreviation me = new Abbreviation();
    me.generateAbbreviations("word");
  }

  private List<String> generateAbbreviations(String word) {
    List<String> result = new ArrayList<>();
    abbreviate(word, result, 0, "");
    return result;
  }

  private void abbreviate(String word, List<String> result, int index, String formedWord) {
    if (index == word.length()) {
      result.add(formedWord);
      return;
    }

    if (index > 0) {
      abbreviate(word, result, index + 1, formedWord + word.charAt(index));
      int newWordLength = formedWord.length();
      if (Character.isDigit(formedWord.charAt(newWordLength - 1))) {
        String formedWordMinusLastChar = formedWord.substring(0, newWordLength - 1);
        char lastChar = formedWord.charAt(newWordLength - 1);
        int nextValue = lastChar - '0';
        nextValue++;
        abbreviate(word, result, index + 1, formedWordMinusLastChar + nextValue);
      } else {
        abbreviate(word, result, index + 1, formedWord + "1");
      }

    } else {

      abbreviate(word, result, index + 1, Character.toString(word.charAt(index)));
      abbreviate(word, result, index + 1, "1");
    }
  }
}
