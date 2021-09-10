/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   9/10/21, 12:00 AM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
  public static void main(String[] args) {
    LetterCombinations me = new LetterCombinations();
  }

  public List<String> letterCombinations(String digits) {
    String[] lookup =
        new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", ""};

    List<String> result = new ArrayList<>();
    if (digits.equals("")) return result;
    generate(lookup, result, new StringBuilder(""), digits, 0);
    return result;
  }

  public void generate(
      String[] lookup, List<String> result, StringBuilder word, String digits, int index) {
    if (word.length() == digits.length()) {
      result.add(word.toString());
      return;
    }

    String nextWord = lookup[digits.charAt(index) - '0'];
    for (char c : nextWord.toCharArray()) {
      generate(lookup, result, word.append(c), digits, index + 1);
      word.deleteCharAt(word.length() - 1);
    }
  }
}
