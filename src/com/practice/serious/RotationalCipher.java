/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/25/21, 12:44 AM
 * =========================================
 */

package com.practice.serious;

public class RotationalCipher {
  public static void main(String[] args) {
    RotationalCipher me = new RotationalCipher();
  }

  String rotationalCipher(String input, int rotationFactor) {
    // Write your code here
    StringBuilder res = new StringBuilder();
    for (char c : input.toCharArray()) {
      if (Character.isDigit(c)) {
        res.append(getShiftIndexNum(c, rotationFactor));
      } else if (Character.isAlphabetic(c)) {
        res.append(getShiftIndexChar(c, rotationFactor));
      } else {
        res.append(c);
      }
    }
    return res.toString();
  }

  char getShiftIndexChar(char c, int rotationFactor) {
    int netfactor = rotationFactor % 26;
    if (Character.isLowerCase(c)) {
      if (c + netfactor > 'z') {
        return (char) (c - (26 - netfactor));
      } else {
        return (char) (c + netfactor);
      }
    } else {
      if (c + netfactor > 'Z') {
        return (char) (c - (26 - netfactor));
      } else {
        return (char) (c + netfactor);
      }
    }
  }

  char getShiftIndexNum(char c, int rotationFactor) {
    int netfactor = rotationFactor % 10;
    int value = c - '0';

    if ((value + netfactor) > 9) return (char) (value - (10 - netfactor) + '0');
    else return (char) (value + netfactor + '0');
  }
}
