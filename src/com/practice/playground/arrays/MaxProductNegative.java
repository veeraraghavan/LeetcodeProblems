package com.practice.playground.arrays;

import javax.swing.text.MaskFormatter;

public class MaxProductNegative {
    public static void main(String[] args) {
        MaxProductNegative me = new MaxProductNegative();
        int[] input = {-2, 0, -1};
        System.out.println(me.maxProduct(input));
    }

    public int maxProduct(int[] nums) {
//        int result = Integer.MIN_VALUE, cump = 1, cumn = 1, temp;
//
//        for (int num : nums) {
//            if (num >= 0) {
//                cump = Math.max(num, cump * num);
//                cumn = Math.min(num, cumn * num);
//            } else {
//                temp = Math.max(num, cumn * num);
//                cumn = Math.min(num, cump * num);
//                cump = temp;
//            }
//
//            result = Math.max(cump, result);
//        }
//
//        return result;
        int productPositive = 1, productNegative = 1, result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= 0) {
                productPositive = Math.max(num, productPositive * num);
                productNegative = Math.min(num, productNegative * num);

            } else {
                int temp = Math.max(productNegative * num, num);
                productNegative = Math.min(productPositive * num, num);
                productPositive = temp;
            }
            result = Math.max(result, productPositive);

        }
        return result;
    }
}
