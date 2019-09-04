package com.practice.playground.arrays;

public class ProductWithoutSelf {
    public static void main(String[] args) {
        ProductWithoutSelf me = new ProductWithoutSelf();
        int[] input ={1,2,3,4};
        System.out.println(me.productExceptSelf(input));
    }
    public int[] productExceptSelf(int[] nums) {
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        int [] result = new int[nums.length];
        left[0]=nums[0];
        right[nums.length-1]=nums[nums.length-1];
        for(int i =1;i<nums.length;i++ ){
            left[i] = left[i-1]*left[i];
        }
        for(int i = nums.length-2;i>=0;i-- ){
            right[i] = right[i] *right[i+1];
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                result[i] = 1*right[i+1];
            }
            else if(i==nums.length-1){
                result[i] = 1*left[i-1];

            }else{
                result[i] = left[i-1] * right[i+1];
            }

        }
        return result;


    }
}
