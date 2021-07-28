package com.practice.scribble;

import java.util.Arrays;

public class Decode {
    public static void main(String[] args) {
        Decode me = new Decode();
        System.out.println(me.numDecodingsRecursive("12212"));

    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - '0' > 0)
                dp[i] = dp[i] + dp[i - 1];
            int temp = Integer.parseInt(s.substring(i - 1, i + 1));
            if (temp >= 10 && temp <= 26) {
                dp[i] = i != 1 ? dp[i] + dp[i - 2] : dp[i] + 1;
            }

        }
        return dp[s.length() - 1];

    }

    public int numDecodingsRecursive(String s) {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return numWays(s,dp,0);


    }

    private int numWays(String s, int[] dp, int index) {
        if (index >= s.length())
            return 1;
        if (dp[index] != -1)
            return dp[index];
        int numDecodings = 0;
        for (int i = 1; i <= 2; i++) {
            if (index + i <= s.length()) {
                String snippet = s.substring(index, index + i);
                if (isValid(snippet)) {
                    numDecodings += numWays(s, dp, index + i);
                }
            }
        }
        dp[index] = numDecodings;
        return numDecodings;
    }

    private boolean isValid(String snippet) {
        if (snippet.length() == 0 || snippet.charAt(0) == '0')
            return false;
        int value = Integer.parseInt(snippet);
        return value >= 1 && value <= 26;

    }
}
