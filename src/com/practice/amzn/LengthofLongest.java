package com.practice.amzn;

public class LengthofLongest {
    public static void main(String[] args) {
        LengthofLongest me = new LengthofLongest();
        System.out.println(me.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int[] visited = new int[256];
        for(int i=0;i<visited.length;i++)
            visited[i]=-1;
        int left=0,right=0;
        int length=0;
        while(right<s.length() && left<=right){
            if(visited[s.charAt(right)]==-1){
                visited[s.charAt(right)]=0;
                right++;
                length=Math.max(length,right-left);
            }else{
                visited[s.charAt(left)]=-1;
                left++;
            }
        }
        return length;

    }
}
