package com.practice.playground.string;

public class LongestSubstringLength {
    public static void main(String[] args) {
        LongestSubstringLength me = new LongestSubstringLength();
        System.out.println(me.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int result=0;int length=0;
        int[] visited = new int[256];
        for(int i=0;i<visited.length;i++){
            visited[i]=-1;
        }
        int left=0,right=0;
        while(right<s.length()){
            if(visited[s.charAt(right)]==-1){
                visited[s.charAt(right)]=0;
                right++;
                result = result<(right-left)?(right-left):result;
            }else{
                visited[s.charAt(left)]=-1;
                left++;
            }

        }
        return result;
    }
//    public int lengthOfLongestSubstring(String s) {
//        int[] visited = new int[256];
//        int left=0,right=0;
//        int max_len = 0;
//        for(int i=0;i<256;i++)
//            visited[i] = -1;
//        while(right < s.length()){
//            if(visited[s.charAt(right)]==-1){
//                visited[s.charAt(right)] = 0;
//                right++;
//                max_len = (max_len>(right-left))?max_len:right-left;
//                //index++;
//            }else {
//                visited[s.charAt(left)] = -1;
//                left++;
//            }
//        }
//
//
//        return max_len;
//
//    }
}
