/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   5/22/21, 11:13 PM
 * =========================================
 */

package com.practice.scribble;

public class NextLargestLetter {
  public static void main(String[] args) {
    NextLargestLetter me = new NextLargestLetter();
    System.out.println(NextLargestLetter.searchNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'f'));
    System.out.println(NextLargestLetter.searchNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'b'));
    System.out.println(NextLargestLetter.searchNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'm'));
    System.out.println(NextLargestLetter.searchNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'h'));
  }

  private static char searchNextLetter(char[] letters, char key) {
    int n = letters.length;
    if (key < letters[0] || key > letters[n - 1]) return letters[0];

    int start = 0, end = n - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (key < letters[mid]) {
        end = mid - 1;
      } else { // if (key >= letters[mid]) {
        start = mid + 1;
      }
    }
    // since the loop is running until 'start <= end', so at the end of the while loop, 'start ==
    // end+1'
    return letters[start % n];
  }
}
