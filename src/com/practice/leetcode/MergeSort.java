package com.practice.leetcode;

public class MergeSort {
    public int[] helper;
    public static void main(String[] args) {
        MergeSort me = new MergeSort();
        int[] a = {6,5,4,3,2,1};
        me.helper = new int[a.length];
        me.mergeSort(a,0,a.length-1);
        for (int i : a)
            System.out.println(i);

    }

    public void mergeSort(int[] a,int low, int high) {
        //Base case
        if(low==high){
            return ;
        }
        try{
            int mid = (low+high)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);

        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Exception");
        }

    }

    public void merge( int[] a,int low,int mid,int high) {
        //Space Complexity 0(n) requires a replica array.
        //Essentially we keep swapping the array between the ranges specified.
        int leftIndex = low;
        int rightIndex = mid+1;
        int k=low;
        int index = low;
        //Copy the helper array
        while(index<=high){
            helper[index] = a[index];
            index++;
        }
        while(leftIndex <= mid && rightIndex <= high){
            if(helper[leftIndex]<= helper[rightIndex]){
                a[k++] = helper[leftIndex++];
            }else{
                a[k++] = helper[rightIndex++];
            }
        }
        while (leftIndex<=mid){
            a[k++] = helper[leftIndex++];
        }
        while ((rightIndex<=high)){
            a[k++] = helper[rightIndex++];
        }
    }
}
