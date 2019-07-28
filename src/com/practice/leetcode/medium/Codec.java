package com.practice.leetcode.medium;

import java.util.ArrayList;

public class Codec {
    private ArrayList<String> url = new ArrayList<String>();
    public String encode(String longUrl) {
        url.add(longUrl);

        return "http://tinyuyrl/"+url.size();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer index = Integer.parseInt(shortUrl.substring(16));
        return url.get(index-1);
    }

    public static void main(String[] args) {
        Codec me = new Codec();
        System.out.println(me.decode(me.encode("www.google.com")));
    }
}
