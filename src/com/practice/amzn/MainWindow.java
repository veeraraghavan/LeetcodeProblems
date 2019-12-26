package com.practice.amzn;

import java.util.HashMap;

public class MainWindow {
    public static void main(String[] args) {
        MainWindow me = new MainWindow();
        //"cabwefgewcwaefgcf"
        //"cae"
        System.out.println(me.minWindow1("cabwefgewcwaefgcf", "cae"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.length() == 0)
            return "";
        if (s.length() == t.length())
            return compare(s, t) ? s : "";

        HashMap<Character, Integer> dictionaryT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictionaryT.put(c, dictionaryT.getOrDefault(c, 0) + 1);
        }
        int reguiredLength = dictionaryT.size();
        int formedLength = 0;
        int left = 0, right = t.length() - 1, leftResult = 0, RightResult = 0, minLength = Integer.MAX_VALUE;
        String result = "";
        while (left <= s.length() - t.length() && right < s.length()) {
            if (compare(s.substring(left, right + 1), t)) {
                if (minLength > (right - left + 1)) {
                    minLength = right - left + 1;
                    leftResult = left;
                    RightResult = right;
                }
                // minLength = Math.min(right - left + 1, minLength);

                left++;

            } else {
                right++;
            }
        }
        if (minLength == Integer.MAX_VALUE) return "";
        String temp = right != s.length() ? s.substring(leftResult) : s.substring(leftResult, RightResult + 1);
        return temp;

    }

    public boolean compare(String a, String b) {
        int[] aMap = new int[256], bMap = new int[256];
        for (char c : a.toCharArray())
            aMap[c]++;
        for (char c : b.toCharArray())
            bMap[c]++;
        for (int i = 0; i < 256; i++) {
            if (aMap[i] < bMap[i] && bMap[i] != 0) return false;
        }
        return true;
    }

    public String minWindow1(String s, String t) {
        if (t.length() > s.length() || t.length() == 0)
            return "";
        if (s.length() == t.length())
            return compare(s, t) ? s : "";

        HashMap<Character, Integer> dictionaryT = new HashMap<>();
        HashMap<Character, Integer> dictionaryS = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictionaryT.put(c, dictionaryT.getOrDefault(c, 0) + 1);
        }
        int requiredLength = dictionaryT.size();
        int formedLength = 0;
        int[] ans = {Integer.MAX_VALUE, 0, 0};
        int left = 0, right = 0;
        while (right < s.length()) {
            dictionaryS.put(s.charAt(right), dictionaryS.getOrDefault(s.charAt(right), 0) + 1);
            if (dictionaryT.containsKey(s.charAt(right)) && dictionaryS.get(s.charAt(right)).intValue() == dictionaryT.get(s.charAt(right)).intValue()) {
                formedLength++;
            }
            while (left <= right && formedLength == requiredLength) {
                if (ans[0] > (right - left + 1)) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                if (dictionaryT.containsKey(s.charAt(left)) && dictionaryS.get(s.charAt(left)).intValue() == dictionaryT.get(s.charAt(left)).intValue()) {
                    formedLength--;
                }
                dictionaryS.put(s.charAt(left), dictionaryS.get(s.charAt(left)) - 1);
                left++;
            }

            right++;
        }
        //Integer.reverse()
        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
