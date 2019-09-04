package com.practice.amzn;

import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        isValid me = new isValid();
        System.out.println(me.isValid("]"));
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c :s.toCharArray()){
            if(c=='(')st.push(')');
            else if(c=='[')st.push(']');
            else if(c=='{')st.push('}');
            else if( (!st.isEmpty() && st.pop()!=c) || st.isEmpty()  )return false;
        }
        return st.isEmpty();
    }
}
