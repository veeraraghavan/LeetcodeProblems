    package com.practice.leetcode;

    import java.util.HashSet;
    import java.util.Set;

    public class Main {

        //Problem https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
        //Good explanation from https://www.youtube.com/watch?v=mtHelVTLKRQ
        /*Essentially find a left pointer and right pointer - Keep a visited array for the 26 characters in English alphabet
        * Keep moving the right character until you encounter a repeating character
        * On encountering please keep moving left character */
        /*Space Complexity O(1) - fixed size for alphabet array
        * Time complexity - O(n)*/

        public static void main(String[] args) {
            Main me = new Main();
            System.out.println("abcabcbbahahosaksjjswjajdjdjeoakahahadkdkdhaha".length());
            System.out.println(me.longestSubstring("abcabcbbahahosaksjjswjajdjdjeoakahahadkdkdhaha"));
            System.out.println(me.getUniqueCharacterSubstringBruteForce("abcabcbbahahosaksjjswjajdjdjeoakahahadkdkdhaha"));
        // write your code here
        }

        public int longestSubstring(String s){
            int[] visited = new int[256];
            int index=0;
            int left=0,right=0;
            int max_len = 0;
            for(int i=0;i<256;i++)
                visited[i] = -1;
            int counter = 0;
            while(index < s.length()){
                counter++;
                if(visited[s.charAt(right)]==-1){
                    visited[s.charAt(right)] = 0;
                    right++;
                    max_len = (max_len>(right-left))?max_len:right-left;
                    index++;
                }else {
                    visited[s.charAt(left)] = -1;
                    left++;
                }
            }
            System.out.println(counter);
            return max_len;
        }

        public int getUniqueCharacterSubstringBruteForce(String input) {
            String output = "";
            for (int start = 0; start < input.length(); start++) {
                Set<Character> visited = new HashSet<>();
                int end = start;
                for (; end < input.length(); end++) {
                    char currChar = input.charAt(end);
                    if (visited.contains(currChar)) {
                        break;
                    } else {
                        visited.add(currChar);
                    }
                }
                if (output.length() < end - start + 1) {
                    output = input.substring(start, end);
                }
            }
            return output.length();
        }
    }
