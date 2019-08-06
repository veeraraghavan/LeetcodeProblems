package com.practice.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class Compress {
    public static void main(String[] args) {
        Compress me = new Compress();
        System.out.println(me.compress("aabbccc".toCharArray()));

    }

    public int compress(char[] chars) {
        int count = 1;
        int result = 0;
        int writeIndex = 0;
        int i = 0;
        for (i = 1; i < chars.length; i++) {
            if (chars[i] - chars[i - 1] == 0) {
                count++;
            } else {
                if (count > 1) {
                    chars[writeIndex++] = chars[i - 1];
                    String temp = String.valueOf(count);
                    for (int j = 0; j < temp.length(); j++) {
                        chars[writeIndex++] = temp.charAt(j);

                    }
                    result += temp.length() + 1;


                } else {
                    result += 1;
                    chars[writeIndex++] = chars[i - 1];
                }
                count = 1;
            }

        }
        if (count > 1) {

            chars[writeIndex++] = chars[i - 1];
            String temp = String.valueOf(count);
            for (int j = 0; j < temp.length(); j++) {
                chars[writeIndex++] = temp.charAt(j);

            }
            result += temp.length() + 1;
        } else {
            result += 1;
            chars[writeIndex++] = chars[i - 1];
        }
        return result;

    }
}
