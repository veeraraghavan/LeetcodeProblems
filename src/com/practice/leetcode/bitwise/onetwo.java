package com.practice.leetcode.bitwise;

public class onetwo {
    public static void main(String[] args) {
        onetwo me = new onetwo();
        int[] bits={1, 0, 0};
        System.out.println(me.isOneBitCharacter(bits));
    }
    public boolean isOneBitCharacter(int[] bits) {
        int prev = 100;
        if(bits.length==1){
            if(bits[0]==0)
                return true;
            return false;
        }
        for(int i=0;i<bits.length;i++){
           if(i==0)
               prev=bits[i];
           else if(i==bits.length-1){
               if(prev!=1 && bits[i]==0)
                   return true;
               return false;
           }else{
               if(prev==1){
                   prev=100;
               }else{
                   prev=bits[i];
               }

           }

        }
        return false;

    }
}
