package com.practice.amzn;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() != 0) {
            String[] lookup = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            generateLetterCombinations(lookup, digits, 0, "", result);
        }
        return result;
    }

    public void generateLetterCombinations(String[] lookup, String digits, int index, String currentString, List<String> result) {
        if (index == digits.length()) {
            result.add(currentString);
            return;
        }
        String numberMap = lookup[digits.charAt(index) - '0'];
        for (char c : numberMap.toCharArray()) {
            String stringWithNextChar = currentString + c;
            generateLetterCombinations(lookup, digits, index + 1, stringWithNextChar, result);
        }
    }
}
