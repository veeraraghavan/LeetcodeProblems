/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/25/21, 7:42 PM
 * =========================================
 */

package com.practice.serious;

public class ValidateIPAddress {
  public static void main(String[] args) {
    ValidateIPAddress me = new ValidateIPAddress();
    System.out.println(me.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
  }

  public String validIPAddress(String IP) {
    // return "IPv6";
    if (IP.length() > 40) return "Neither";
    String[] split = IP.split(":", -1);

    if (split.length == 8) {
      return isValidIP6(split);

    } else {
      split = IP.split("\\.", -1);
      if (split.length == 4) {
        return isValidIP4(split);
      }
    }
    return "Neither";
  }

  public String isValidIP4(String[] IP) {
    for (String ip : IP) {
      char[] cip = ip.toCharArray();
      int start = 0;
      int second = 0;
      if (cip.length == 0) return "Neither";
      if (cip.length == 1 && cip[0] == '0') continue;
      for (int i = 0; i < cip.length; i++) {

        if (Character.isDigit(cip[i])) {
          int digit = cip[i] - '0';
          if (i == 0) {
            if (digit < 3 && digit != 0) {
              start = digit;
              continue;
            }
          } else if (i == 1) {
            if ((digit < 6 && start == 2) || start == 1) {
              second = digit;
              continue;
            }
          } else {
            int sum = (start * 100) + (second * 10) + digit;
            if (sum < 256) continue;
          }
          return "Neither";
        }
        return "Neither";
      }
    }
    return "IPv4";
  }

  public String isValidIP6(String[] IP) {
    for (String ip : IP) {
      if (ip.length() > 4 || ip.equals("")) return "Neither";
      for (char c : ip.toCharArray()) {
        if (Character.isAlphabetic(c) || Character.isDigit(c)) {
          if (Character.isAlphabetic(c)) {
            int digit = 0;
            if (Character.isLowerCase(c)) {
              digit = c - 'a';
            } else {
              digit = c - 'A';
            }
            if (digit > 5) return "Neither";
          }
          continue;
        }
        return "Neither";
      }
    }
    return "IPv6";
  }
}
