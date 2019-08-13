package com.practice.playground.misc;

public class CanIWin {
    public static void main(String[] args) {
        CanIWin me = new CanIWin();
        System.out.println(me.canIWin(10,11));
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


//    Map<String, Boolean> memo; // key: chosen[] to string, value: canIWinWithSituation return value when chosen to string is key
//
//    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
//
//        if (desiredTotal <= maxChoosableInteger)
//            return true;
//        if (((1 + maxChoosableInteger) / 2 * maxChoosableInteger) < desiredTotal) {
//            return false;
//        }
//        memo = new HashMap<>();
//
//        return canIWinWithSituation(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
//    }
//
//    private boolean canIWinWithSituation(int maxChoosableInteger, int curDesiredTotal, boolean[] chosen) {
//
//        if (curDesiredTotal <= 0) {
//            return false;
//        }
//
//        String chosenSerialization = Arrays.toString(chosen);
//        if (memo.containsKey(chosenSerialization)) {
//            return memo.get(chosenSerialization);
//        }
//
//        for (int i = 1; i <= maxChoosableInteger; i++) {
//            if (chosen[i]) {
//                continue;
//            }
//            chosen[i] = true;
//            if (!canIWinWithSituation(maxChoosableInteger, curDesiredTotal - i, chosen)) {
//                memo.put(chosenSerialization, true);
//                chosen[i] = false;
//                return true;
//            }
//            chosen[i] = false;
//        }
//        memo.put(chosenSerialization, false);
//        return false;
//    }
}
