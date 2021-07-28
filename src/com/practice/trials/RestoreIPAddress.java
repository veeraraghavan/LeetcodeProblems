package com.practice.trials;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
  public static void main(String[] args) {
    RestoreIPAddress me = new RestoreIPAddress();
    System.out.println(me.getValidIP("0000"));
  }

  private List<String> getValidIP(String number) {
    List<String> result = new ArrayList<>();
    traverseIP(1, result, "", 0, number);
    return result;
  }

  private void traverseIP(int level, List<String> result, String current, int index, String input) {
    if (level > 4) return;
    if (level == 1) {
      for (int i = index + 1; i < index + 4 && i < input.length(); i++) {
        String part = input.substring(index, i);
        if (validIP(part)) {
          traverseIP(level + 1, result, part, i, input);
        }
      }

    } else if (level == 2) {
      for (int i = index + 1; i < index + 4 && i < input.length(); i++) {
        if (index > input.length() - 3) return;
        String part = input.substring(index, i);
        if (validIP(part)) {
          traverseIP(level + 1, result, current + "." + part, i, input);
        }
      }

    } else if (level == 3) {
      for (int i = index + 1; i < index + 4 && i < input.length(); i++) {
        if (index > input.length() - 2) return;
        String part = input.substring(index, i);
        if (validIP(part)) {
          traverseIP(level + 1, result, current + "." + part, i, input);
        }
      }

    } else if (level == 4) {
      if (input.length() - index <= 3) {
        if (index > input.length() - 1) return;
        String part = input.substring(index);
        if (validIP(part)) {
          result.add(current + "." + part);
        }
      }
    }
  }

  private boolean validIP(String part) {
    if (part.charAt(0) == '0' && part.length() > 1) {
      return false;
    } else if (Integer.parseInt(part) > 255) {
      return false;
    }
    return true;
  }

  private void restore(int index, String s, int level, String cur, List<String> res) {
    if (level > 4) return;

    if (level == 1) { // first segment
      for (int i = index + 1; i <= 3; i++) {
        cur = s.substring(index, i);
        if (!isValid(cur)) return;
        restore(i, s, level + 1, cur, res);
      }

    } else if (level == 2) {
      if (index > s.length() - 3) return; // atleast 3 chars needed
      for (int i = index + 1; i <= (index + 3); i++) {
        String temp = s.substring(index, i);
        if (!isValid(temp)) return;
        restore(i, s, level + 1, cur + "." + temp, res);
      }

    } else if (level == 3) {
      if (index > s.length() - 2) return; // atleast 2 chars needed
      for (int i = index + 1; i <= (index + 3); i++) {
        if (i > s.length()) return;
        String temp = s.substring(index, i);
        if (!isValid(temp)) return;
        restore(i, s, level + 1, cur + "." + temp, res);
      }

    } else if (level == 4) {
      if (index > s.length() - 1) return; // atleast 1 chars needed
      String temp = s.substring(index);
      if (!isValid(temp)) return;
      res.add(cur + "." + temp);
    }
  }

  private boolean isValid(String s) {
    if ((s.length() > 4)
        || // can't be greater than 4
        (Integer.parseInt(s) > 255)
        || // should be less than 255
        (s.charAt(0) == '0' && s.length() > 1)) // can't start with 0
    return false;

    return true;
  }
}
