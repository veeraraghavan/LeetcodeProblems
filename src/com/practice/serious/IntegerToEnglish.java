/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/25/21, 1:24 PM
 * =========================================
 */

package com.practice.serious;

public class IntegerToEnglish {
  public static void main(String[] args) {
    IntegerToEnglish me = new IntegerToEnglish();
  }

  StringBuilder sb = new StringBuilder();

  public String numberToWords(int num) {
    numberToString(num);
    sb.deleteCharAt(0);
    return sb.toString();
  }

  public void numberToString(int num) {
    int number = num;
    while (number > 0) {
      if (number >= 1000000000) {
        int remainder = number / 1000000000;
        numberToString(remainder);
        sb.append(" Billion");
        number %= 1000000000;
      } else if (number >= 1000000) {
        int remainder = number / 1000000;
        numberToString(remainder);
        sb.append(" Million");
        number %= 1000000;
      } else if (number >= 1000) {
        int remainder = number / 1000;
        numberToString(remainder);
        sb.append(" Thousand");
        number %= 1000;

      } else if (number >= 100) {
        int remainder = number / 100;
        numberToString(remainder);
        sb.append(" Hundred");
        number %= 100;
      } else if (number >= 10) {
        if (number >= 90) {
          sb.append(" Ninety");
          number %= 90;
        } else if (number >= 80) {
          sb.append(" Eighty");
          number %= 80;

        } else if (number >= 70) {
          sb.append(" Seventy");
          number %= 70;

        } else if (number >= 60) {
          sb.append(" Sixty");
          number %= 60;

        } else if (number >= 50) {
          sb.append(" Fifty");
          number %= 50;

        } else if (number >= 40) {
          sb.append(" Forty");
          number %= 40;

        } else if (number >= 30) {
          sb.append(" Thirty");
          number %= 30;

        } else if (number >= 20) {
          sb.append(" Twenty");
          number %= 20;

        } else if (number >= 10) {
          switch (number) {
            case 10:
              sb.append(" Ten");
              break;
            case 11:
              sb.append(" Eleven");
              break;
            case 12:
              sb.append(" Twelve");
              break;
            case 13:
              sb.append(" Thirteen");
              break;
            case 14:
              sb.append(" Fourteen");
              break;
            case 15:
              sb.append(" Fifteen");
              break;
            case 16:
              sb.append(" Sixteen");
              break;
            case 17:
              sb.append(" Seventeen");
              break;
            case 18:
              sb.append(" Eighteen");
              break;
            case 19:
              sb.append(" Nineteen");
              break;
          }
          number = 0;
        }

      } else {

        switch (number) {
          case 1:
            sb.append(" One");
            break;
          case 2:
            sb.append(" Two");
            break;
          case 3:
            sb.append(" Three");
            break;
          case 4:
            sb.append(" Four");
            break;
          case 5:
            sb.append(" Five");
            break;
          case 6:
            sb.append(" Six");
            break;
          case 7:
            sb.append(" Seven");
            break;
          case 8:
            sb.append(" Eight");
            break;
          case 9:
            sb.append(" Nine");
            break;
        }
        number = 0;
      }
    }
  }
}
