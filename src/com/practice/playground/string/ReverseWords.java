package com.practice.playground.string;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords me = new ReverseWords();
//        System.out.println(me.reverseWords("Hello World"));
//        System.out.println(me.reverseWords("  hello world!  "));
        System.out.println("    ");
    }

    public String reverseWords(String s) {
        if (s.equals(" ") || s.equals(""))
            return s;
        String text = reverse(s);
        String result = "";
        int i = 0;
        while (i < text.length()) {
            int start = i;
            while (i < text.length() && !Character.isSpaceChar(text.charAt(i))) {
                i++;
            }
            int end = i;
            result += reverse(text.substring(start, end));
            if (i < text.length() && Character.isSpaceChar(text.charAt(i))) {
                result += " ";
                i++;
            }
        }
        int start = 0, end = result.length() - 1;
        while (start < result.length()) {
            if (Character.isSpaceChar(result.charAt(start)))
                start++;
            else
                break;
        }
        while (end >= 0) {
            if (Character.isSpaceChar(result.charAt(end)))
                end--;
            else break;
        }


        return result.substring(start, end + 1);

    }

    public String reverse(String text) {
        int i = 0, j = text.length() - 1;
        char[] textC = text.toCharArray();
        while (i < j) {
            char c = textC[i];
            textC[i] = textC[j];
            textC[j] = c;
            i++;
            j--;

        }
        return String.valueOf(textC);

    }
}
