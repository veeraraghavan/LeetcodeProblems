package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidateIP {
    public static void main(String[] args) {
        System.out.println(new ValidateIP().validateIP("01.01.01.01"));
    }

    public String validateIP(String IP) {
        if (IP.contains(".")) {
            return isIPV4(IP);

        } else if (IP.contains(":")) {
            return isIPV6(IP);
        } else {
            return "Neither";
        }

    }

    public String isIPV4(String IP) {
        if (IP.startsWith(".") || IP.endsWith(".") || IP.contains("-")) {
            return "Neither";
        } else {
            String[] ipTuples = IP.split("\\.");
            if (ipTuples.length != 4) {
                return "Neither";
            } else {
                for (String tuple : ipTuples) {
                    try {

                        if (tuple.startsWith("0") && tuple.length() > 1) {
                            return "Neither";
                        }

                        int value = Integer.parseInt(tuple);
                        if (value > 255 || value < 0) {
                            return "Neither";
                        }
                    } catch (NumberFormatException e) {
                        return "Neither";
                    }
                }
            }
        }
        return "IPv4";
    }

    public String isIPV6(String ip) {
        Set<String> alphabets = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e", "f", "A", "B", "C", "D", "E", "F"));
        if (ip.startsWith(":") || ip.endsWith(":")) {
            return "Neither";
        } else {
            String[] ipTuples = ip.split("\\:");
            if (ipTuples.length != 8) {
                return "Neither";
            } else {
                for (String tuple : ipTuples) {
                    if (tuple.length() > 4 || tuple.length() < 1) {
                        return "Neither";
                    }
                    for (char c : tuple.toCharArray()) {
                        if (!Character.isDigit(c) && !alphabets.contains(Character.toString(c))) {
                            return "Neither";
                        }
                    }
                }
            }
        }
        return "IPv6";
    }
}
