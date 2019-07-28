package com.practice.leetcode.string;

public class Monotone {
    public static void main(String[] args) {
        Monotone me = new Monotone();
        System.out.println(me.monotoneIncreasingDigits(332));
        System.out.println(1234);
        System.out.println(10);
    }

    public int monotoneIncreasingDigits(int N) {
//        int temp = N;
//        while (temp >= 0) {
//            if (isMonotone(temp)) {
//                return temp;
//            }
//            temp -= 1;
//        }
        if(isMonotone(N)){
            return N;
        }
        StringBuilder input = new StringBuilder(String.valueOf(N));
        int i = 1;
        while (i < input.length() && input.charAt(i - 1) <= input.charAt(i)) {
            i++;
        }

        int j = i;
        j--;
        char temp = input.charAt(j);
        temp--;
        input.setCharAt(j, (char) temp);
        while (j > 0 && input.charAt(j) < input.charAt(j - 1)) {
            input.setCharAt(j, '9');
            char c = input.charAt(j - 1);
            c--;
            input.setCharAt(--j, c);
            // j--;
        }
        while (i < input.length()) {
            input.setCharAt(i++, '9');

        }

        return Integer.parseInt(input.toString());


    }

    public boolean isMonotone(int n) {
        String s = Integer.toString(n);
        boolean isMonotone = true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return !isMonotone;
            }

        }
        return isMonotone;
    }
}
