package com.practice.amzn;

public class RomanToEnglish {
  public static void main(String[] args) {
    RomanToEnglish me = new RomanToEnglish();
    System.out.println(me.romanToInt("MCMXCIV"));
  }

  public int romanToInt(String s) {
    char prev = ' ';
    int number = 0;
    for (char c : s.toCharArray()) {
      number = getValue(number, c, prev);
      prev = c;
    }
    return number;
  }

  public int getValue(int number, char current, char prev) {
    if (current == 'M' && prev == 'C') return number - 100 + 900;
    else if (current == 'D' && prev == 'C') return number - 100 + 400;
    else if (current == 'C' && prev == 'X') return number - 10 + 90;
    else if (current == 'L' && prev == 'X') return number - 10 + 40;
    else if (current == 'X' && prev == 'I') return number - 1 + 9;
    else if (current == 'V' && prev == 'I') return number - 1 + 4;
    else if (current == 'M') return number + 1000;
    else if (current == 'D') return number + 400;
    else if (current == 'C') return number + 100;
    else if (current == 'L') return number + 50;
    else if (current == 'X') return number + 10;
    else if (current == 'V') return number + 5;
    else if (current == 'I') return number + 1;
    else return number;
  }
}
