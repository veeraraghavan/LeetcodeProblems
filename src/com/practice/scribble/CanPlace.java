package com.practice.scribble;

public class CanPlace {
    public static void main(String[] args) {
        CanPlace me = new CanPlace();
        System.out.println(me.canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 1));

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int temp = n;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    temp--;
                }
                i++;
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    temp--;
                }
                i++;
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    temp--;
                }
            }
            if(temp==0)
                return true;

        }
        return false;

    }
}
