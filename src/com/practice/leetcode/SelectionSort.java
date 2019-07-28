package com.practice.leetcode;

public class SelectionSort {
    public static void main(String[] args){
        SelectionSort me = new SelectionSort();
        int[] a = {45,1,2,43,33,56,89,6554,7};
        me.selectionSort(a);
        for(int i: a){
            System.out.print(i);
        }

    }
    public void selectionSort(int[] a){

        for(int i=0;i<a.length-1;i++){
            int lowest = a[i];
            int index=i;
            for(int j=i+1;j<a.length;j++){
                if(lowest>a[j]){
                    lowest = a[j];
                    index =j;
                }
            }
            if(a[i]!=lowest){
                int temp = a[index];
                 a[index] = a[i];
                 a[i]=temp;

            }
        }

    }
}
