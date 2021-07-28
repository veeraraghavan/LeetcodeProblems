/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   7/26/21, 9:25 PM
 * =========================================
 */

package com.practice.serious;

public class StringInterleaving {
  public static void main(String[] args) {
    StringInterleaving me = new StringInterleaving();
    System.out.println(me.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
  }

  private boolean isInterleave(String s1, String s2, String s3) {

    if (s3.length() != (s1.length() + s2.length())) {
      return false;
    }
    return dfs(s1, 0, s2, 0, s3, 0, new boolean[s1.length() + 1][s2.length() + 1]);
  }

  private boolean dfs(
      String s1, int i1, String s2, int i2, String s3, int i3, boolean[][] invalid) {

    if (invalid[i1][i2]) return false;
    // base condition check if end of full string
    if (s3.length() == i3) return true;
    boolean valid =
        ((i1 < s1.length()
                && s1.charAt(i1) == s3.charAt(i3)
                && dfs(s1, i1 + 1, s2, i2, s3, i3 + 1, invalid))
            || (i2 < s2.length()
                && s2.charAt(i2) == s3.charAt(i3)
                && dfs(s1, i1, s2, i2 + 1, s3, i3 + 1, invalid)));
    if (!valid) invalid[i1][i2] = true;
    return true;
  }
}
