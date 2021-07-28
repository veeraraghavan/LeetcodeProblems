package com.practice.scribble;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive me = new FirstMissingPositive();
        System.out.println(me.firstMissingPositive(new int[]{1,2,3,4,5,6}));

    }

    public int firstMissingPositive(int[] arr) {
        /*
        The largest possible number that be a First missing positive of an Array of size N is N+1.
        Ex - [1,2,3,4,5,6] . The six is the size and hence the largest possible value is N+1.
        Step 1. Scan through the elements to check if 1 is present. If not return 1.
        Step 2. Check if length is 1. If yes , since above condition did not fail, the answer is 2.
        Step 3. Scan through elements ( consider only those which are above 0 and less than N) and set the
        elements at index of of array value to Non-Zero.
        Ex. if 3,2,1 ===> scanning 2 makes element at index 2 negative
        Result :   3,2,-1
        Also note index 0 is used to represent occurrence of N.
        Also Note while setting Negative ensure you always set negative considering absolute value
        instead of existing .
        Ex: 1,2,2,3 => When scanning 2
        Result 1,2,-2,3===> Again scanning 2 will make it -(-2) and become positive.
        So the condition
        arr[a] = -Math.abs(arr[a]); where a = nums[i]

        Now finally check if the array contains non zero values and return the first missing positive
        */
        boolean oneExists = false;
        for (int x : arr) {
            if (x == 1)
                oneExists = true;
        }
        if (!oneExists)
            return 1;
        if (arr.length == 1)
            return 2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr.length || arr[i] <= 0)
                arr[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            int a = Math.abs(arr[i]);
            if (a == arr.length)
                arr[0] = -Math.abs(arr[0]);
            else
                arr[a] = -Math.abs(arr[a]);

        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0)
                return i;

        }
        if (arr[0] > 0)
            return arr.length;

        return arr.length + 1;

    }
}
