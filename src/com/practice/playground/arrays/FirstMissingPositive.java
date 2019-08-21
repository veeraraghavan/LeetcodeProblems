package com.practice.playground.arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive me = new FirstMissingPositive();
        int[] input = {1, 2, 0};
        System.out.println(me.firstMissingPositive(input));
    }

    /*
    Eg [0,12,34,-23,1,2,4,-49,-1,-4]
    Intuition : Split the array into two blocks . All negative,0  and all positive.
    Identify the index of i(first non-negative integer).
    [-23,-1,-4,0,12,34,1,2,4] i=3
    Now create an array of length n-i (n => length of input array];
    Array of length 7
    Loop thru split array from i=3, mark the array with a negative number
    [-0,-12,-34,1,-2]
    Loop thru the array and return the first non-negative number.
    If end of loop reached return array length +1.


    */
    public int firstMissingPositive(int[] arr) {
        int split = getSplit(arr);
        int[] newNum = new int[arr.length - split];
        for(int i=0;i<newNum.length;i++)
            newNum[i] = arr[i+split];
        for (int i = split; i < arr.length; i++) {
            int x = arr[i];
            if (x - 1 < newNum.length &&  x-1 >= 0 && newNum[x - 1] > 0 )
                newNum[x - 1] = -newNum[x - 1];
        }
        for (int i = 0; i < newNum.length; i++) {
            if (newNum[i] > 0)
                return i + 1;
        }

        return newNum.length+1;
    }

    public int getSplit(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] <= 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i++] = temp;
            }
        }
        return i;

    }

}
