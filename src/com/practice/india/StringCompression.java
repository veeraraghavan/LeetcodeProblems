package com.practice.india;

public class StringCompression {
  public static void main(String[] args) {
    StringCompression me = new StringCompression();
    System.out.println(me.compress(new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
  }

  private int compress(char[] chars) {
    // There are 3 indexes one to check the current character being read
    // Anchor - hold index of the first character in the sequence
    // Write -  Since we are using O(1) we update the original array with result.
    int write = 0;
    int anchor = 0;

    for (int read = 0; read < chars.length; read++) {
      if ((read + 1 == chars.length) || chars[read] != chars[read + 1]) {
        // only when adjacent characters are different we need to update the original array
        chars[write++] = chars[anchor];
        if (read > anchor) {
          for (char c : ("" + (read - anchor + 1)).toCharArray()) {
            chars[write++] = c;
          }
        }
        anchor = read + 1;
      }
    }

    return write;
  }
}
