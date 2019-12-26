package com.practice.ctci.string;

public class Compression {
    public static void main(String[] args) {
        Compression me = new Compression();
        System.out.println(me.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }

    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read] != chars[read + 1]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor) + 1).toCharArray()) {
                        chars[write++] = c;
                    }

                }
                anchor = read + 1;

            }

        }
        return write;

    }

    public int compressN(char[] chars) {
        int index = 0;
        String result = "";
        while (index < chars.length) {
            char temp = chars[index];
            index++;
            int count = 1;
            while (index < chars.length && temp == chars[index]) {
                count++;
                index++;
            }
            if (count > 1) {
                result += Character.toString(temp) + count;
            }

        }
        return result.length();

    }
}
