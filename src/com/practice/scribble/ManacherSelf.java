package com.practice.scribble;

public class ManacherSelf {
    public static void main(String[] args) {
        ManacherSelf me = new ManacherSelf();
        System.out.println(me.longestSubstring("abcbba"));

    }

    public String longestSubstring(String s) {
        String transformedString = transform(s);
        int right = 0, centre = 0;
        int maxLen=0;
        String result = "";
        int[] P = new int[transformedString.length()];
        for (int i = 0; i < transformedString.length(); i++) {
            int mirror = 2 * centre - i;
            // By the nature of palindrome since we the boundary of the current palindrom is at right
            // the palindrome current i is difference between right and i
            // or palindrome of mirror
            if (i < right) {
                P[i] = Math.min(right - i, P[mirror]);
            }
            int toRight = i + P[i] + 1;
            int toLeft = i - (1 + P[i]);
            while(toRight<transformedString.length() && toLeft>=0 && transformedString.charAt(toLeft)==transformedString.charAt(toRight)){
                //increment the length of palindrome starting at i
                P[i]++;
                toRight++;
                toLeft--;
            }

            // Now check if the right needs to be extended
            if(i+P[i]>right){
                centre=i;
                right = i+P[i];
                if(P[i]>maxLen){
                    maxLen=P[i];
                    result = transformedString.substring(i-P[i],i+P[i]+1);
                }

            }
        }

        return result.replaceAll("#","");
    }

    public String transform(String s) {
        String result = "#";
        for (char c : s.toCharArray()) {
            result += c + "#";
        }
        return result;
    }
}
