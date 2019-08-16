package com.practice.playground.arrays;

public class MissingElement {
    public static void main(String[] args) {
        MissingElement me = new MissingElement();
        int[] input={1,2,4};
        System.out.println(me.missingElement(input,3));

    }
     /* Intuition:
     *  Start with first element as Previous and remainingK as K
     *  Start looking at difference between adjacent array elements
     *  if
     *     difference > remainingK
      *     it means the number lies within the 2 adjacent numbers , so return previous+remainingK
      *    difference < remainingK
      *      lies outside. reduce the remainingK by the difference and prev = current, current = next element
      *
      *    Eg{1,4,7,10) K=3
      *    prev = 1, start loop from i=1(element 4)
      *    At i=1
      *       4-1-1=2    (difference is inclusive greater element . -1 ensure both element are excluded.
      *       remainingK = 3-2=1, prev = 4, current =7
      *    At i=2
      *       7-4-1 = 2 , 2>remainingK(1 in this case). Return prev + remainingK , Answer is 5
     *
     *     Supposed end of array is reached
     *     return last Element + remainingK
     * */
    public int missingElement(int[] nums, int k) {
        int remainingK = k;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - prev - 1) < remainingK) {
                remainingK = remainingK - (nums[i] - prev - 1);
                prev = nums[i];
            } else {
                return prev + remainingK;
            }
        }
        return nums[nums.length-1] + remainingK;
    }
}
