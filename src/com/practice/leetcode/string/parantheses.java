package com.practice.leetcode.string;

import java.util.Stack;

public class parantheses {
    public static void main(String[] args) {
        parantheses me = new parantheses();
        System.out.println(me.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        char prev = '1';
        for (int i = 0; i < s.length(); i++) {
            if (characterStack.empty()) {
                characterStack.push(s.charAt(i));
            } else if (translate(characterStack.get(characterStack.size()-1)) == s.charAt(i)) {
                characterStack.pop();
            } else {
                characterStack.push(s.charAt(i));
            }


        }
        return characterStack.empty();

    }

    public char translate(char input) {
        switch (input) {
            case '{':
                return '}';
            case '[':
                return ']';
            case '(':
                return ')';
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            default:
                return '1';
        }
    }
}
