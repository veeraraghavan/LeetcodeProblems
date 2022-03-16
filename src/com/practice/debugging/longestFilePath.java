/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   2/8/22, 2:06 PM
 * =========================================
 */

package com.practice.debugging;

import java.util.Stack;
import java.util.stream.Collectors;

public class longestFilePath {
  public static void main(String[] args) {
    longestFilePath me = new longestFilePath();
    System.out.println(
        me.lengthLongestPath(
            "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
  }

  public int lengthLongestPath(String input) {
    // Store each directory
    Stack<String> stack = new Stack<>();
    int max = 0;

    for (String row : input.split("\n")) {
      // Store how deep is the current level
      // Root level is level 0 as row.lastIndexOf("\t") == - 1
      int level = row.lastIndexOf("\t") + 1;

      // Go back to the right level getting out of subdirectories
      while (level < stack.size()) {
        stack.pop();
      }

      // Remove \t from line
      String basename = row.substring(level);

      if (basename.contains(".")) {
        // File case
        stack.push(basename);
        // Construct full path joining directories and filename with a "/"
        String fullPath = stack.stream().collect(Collectors.joining("/"));
        max = Math.max(fullPath.length(), max);
        stack.pop();
      } else {
        // Directory case
        stack.push(basename);
      }
    }

    return max;
  }
}
