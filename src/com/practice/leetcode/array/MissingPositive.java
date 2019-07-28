package com.practice.leetcode.array;

//https://leetcode.com/problems/find-the-duplicate-number/
public class MissingPositive {
    public static void main(String[] args) {
        MissingPositive me = new MissingPositive();
        int[] nums = {1,2,0};
        //System.out.println(me.firstMissingPositive(nums));
        System.out.println(me.MissingPositive(nums));
    }

    public int MissingPositive(int[] arr) {
        int splitIndex = SplitArray(arr);
        int[] newNums = new int[arr.length-splitIndex];
        for(int i=0;i<arr.length-splitIndex;i++){
            newNums[i]=arr[splitIndex+i];
        }
        for(int i=0;i<newNums.length;i++){
            int x = Math.abs(newNums[i]);
            if(x-1 < newNums.length && newNums[x-1]>0){
               newNums[x-1] = -newNums[x-1];
            }
        }
        int j=0;
        for(j=0;j<newNums.length;j++){
            if(newNums[j]>0)
                return j+1;
        }
        return newNums.length+1;

    }

    public int SplitArray(int[] nums) {
        int i = 0;
        int temp = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] <= 0) {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        return i;

    }

    public int firstMissingPositive(int[] arr) {
        int shift = segregate (arr, arr.length);
        int arr2[] = new int[arr.length-shift];
        int j=0;
        for(int i=shift;i<arr.length;i++)
        {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);

    }

    public int segregate (int arr[], int size)
    {
        int j = 0, i;
        for(i = 0; i < size; i++)
        {
            if (arr[i] <= 0)
            {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    /* Find the smallest positive missing
       number in an array that contains
       all positive integers */
    public int findMissingPositive(int arr[], int size)
    {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for(i = 0; i < size; i++)
        {
            int x = Math.abs(arr[i]);
            if(x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which
        // is positive
        for(i = 0; i < size; i++)
            if (arr[i] > 0)
                return i+1;  // 1 is added becuase indexes
        // start from 0

        return size+1;
    }
}
