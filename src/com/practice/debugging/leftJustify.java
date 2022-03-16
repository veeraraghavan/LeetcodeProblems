/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   2/17/22, 7:28 PM
 * =========================================
 */

package com.practice.debugging;

import java.util.ArrayList;
import java.util.List;

public class leftJustify {
  public static void main(String[] args) {
    leftJustify me = new leftJustify();
    List<String> res =
        me.fullJustify(
            new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16);
    for (String line : res) System.out.println(line);
    res = me.fullJustify(new String[] {"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
    for (String line : res) System.out.println(line);
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int start = 0;
    while (start < words.length) {
      int end = getEndWord(words, start, maxWidth);
      result.add(formatResult(words, maxWidth, start, end));
      start = end + 1;
    }

    return result;
  }

  private String formatResult(String[] words, int maxWidth, int start, int end) {
    if (end - start == 0) return padResult(words[end], maxWidth);
    boolean isLastLine = end == words.length - 1;
    int numWords = end - start;
    int length = 0;
    for (int i = start; i <= end; i++) {
      length += words[i].length();
    }
    int spaces = maxWidth - length;
    String space = isLastLine ? " " : getSpaceWord(spaces / numWords);

    int remainder = isLastLine ? 0 : spaces % numWords;

    StringBuilder res = new StringBuilder();

    for (int i = start; i <= end; i++) {
      res.append(words[i]).append(space).append(remainder-- > 0 ? " " : "");
    }

    return res.toString();
  }

  private String padResult(String word, int maxWidth) {
    return word + getSpaceWord(maxWidth - word.length());
  }

  public String getSpaceWord(int length) {
    return new String(new char[length]).replace('\0', ' ');
  }

  private int getEndWord(String[] words, int start, int maxWidth) {
    int end = start;
    int length = 0;
    for (; end < words.length; end++) {
      if (length + words[end].length() <= maxWidth) {
        length += words[end].length() + 1;
      } else {
        return end - 1;
      }
    }
    return end - 1;
  }
}
