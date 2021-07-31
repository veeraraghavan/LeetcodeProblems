package com.practice.playground.arrays;

public class Trapped {
  public static void main(String[] args) {
    Trapped me = new Trapped();
    int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(me.trap(input));
  }

  private int trap(int[] height) {
    if (height.length == 0) return 0;
    int left = 0;
    int right = 0;
    int volume = 0;
    int tempVolume = 0;
    int[] maxLeft = new int[height.length];
    maxLeft[0] = height[0];
    for (int i = 1; i < maxLeft.length; i++) {
      maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
    }
    int[] maxRight = new int[height.length];
    maxRight[maxRight.length - 1] = height[height.length - 1];
    for (int i = maxRight.length - 2; i >= 0; i--) {
      maxRight[i] = Math.max(maxRight[i + 1], height[i]);
    }
    for (int i = 1; i < height.length - 1; i++) {
      tempVolume = 0;
      if (i == 0) {

      } else if (i == height.length - 1) {

      } else {
        tempVolume = Math.min(maxLeft[i - 1], maxRight[i + 1]) - height[i];
      }

      if (tempVolume > 0) volume += tempVolume;
    }
    return volume;
  }
  //    public int findMax(int begin,int end,int[] height){
  //        int max=-1;
  //        for(int i=begin;i<end;i++){
  //            if(max<height[i]){
  //                max=height[i];
  //            }
  //        }
  //        return max;
  //    }
}
