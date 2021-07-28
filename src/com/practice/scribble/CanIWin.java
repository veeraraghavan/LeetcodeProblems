package com.practice.scribble;

public class CanIWin {
    public static void main(String[] args) {
        CanIWin me = new CanIWin();
        System.out.println(me.canIWin(11,45));

    }


    byte[] memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) return true;

        // Handle edge case
        int n = maxChoosableInteger;
        int sum = (n * (n + 1)) / 2;
        if (sum < desiredTotal) return false;

        memo = new byte[1 << (n + 1)];

        return p1CanWin(0, n, desiredTotal);
    }

    public boolean p1CanWin(int state, int maxInt, int desiredTotal) {
        if (desiredTotal <= 0) return false;

        if (memo[state] != 0) {
            return (memo[state] == 1);
        }

        for (int i = 1; i <= maxInt; ++i) {
            if ((state & (1 << i)) == 0) {
                boolean res = p1CanWin(state | (1 << i), maxInt, desiredTotal - i);
                if (!res) {
                    memo[state] = 1;
                    return true;
                }
            }
        }

        memo[state] = -1;
        return false;
    }

}
