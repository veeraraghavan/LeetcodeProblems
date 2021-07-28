package com.practice.scribble;

public class DominoRotation {
    public static void main(String[] args) {
        DominoRotation me = new DominoRotation();
        System.out.println(me.minDominoRotations(new int[]{2,1,2,4,2,2},new int[]{5,2,6,2,3,2}));

    }
    public int minDominoRotations(int[] A, int[] B) {
        int result = equal(A[0],A,B);
        if(result!=-1 && A[0]!=B[0]) return result;
        return equal(B[0],A,B);


    }
    public int equal(int x, int[] A, int[] B){
        int a_count=0,b_count=0;
        for(int i=0;i<A.length;i++){
            if(x!=A[i] && x!=B[i]) return -1;
            if(x!=A[i]) a_count++;
            if(x!=B[i]) b_count++;
        }
        return Math.min(a_count,b_count);
    }
}
