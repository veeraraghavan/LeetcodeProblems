package com.practice.playground.dp;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle me = new Triangle();
        List<List<Integer>> input = new ArrayList<>();
        Integer[] row = {2};
        Integer[] row1 = {3, 4};
        Integer[] row2 = {6, 5, 7};
        Integer[] row3 = {4, 1, 8, 3};

        input.add(Arrays.asList(row));
        input.add(Arrays.asList(row1));
        input.add(Arrays.asList(row2));
        input.add(Arrays.asList(row3));
        System.out.println(me.minimumTotal(input));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
//        for (int i = triangle.size() - 2; i >= 0; i--) {
//            List<Integer> temp = triangle.get(i);
//            List<Integer> next = triangle.get(i + 1);
//            for (int j = 0; j < temp.size(); j++) {
//                temp.set(j, temp.get(j) + Math.min(next.get(j), next.get(j + 1)));
//            }
//        }
//        return triangle.get(0).get(0);

        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < size; i++) {
            List<Integer> list = triangle.get(i);
            int previous = dp[0];
            dp[0] += list.get(0);

            //calculating minimum path sum for ith level
            for (int j = 1; j < i; j++) {
                int temp = dp[j];
                dp[j] = list.get(j) + Math.min(previous, dp[j]);
                previous = temp;
            }

            dp[i] = previous + list.get(i);
        }

        int result = dp[0];
        for (int i = 1; i < size; i++) {
            result = Math.min(result, dp[i]);
        }

        return result;

    }
}
