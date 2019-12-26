package com.practice.amzn;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStack me = new MinStack();
        me.push(-2);
        me.push(0);
        me.push(-1);
        System.out.println(me.getMin());
        System.out.println(me.top());
        me.pop();
        System.out.println(me.getMin());
    }

    Stack<Integer> st = new Stack();
    Stack<Integer> min = new Stack();

    public MinStack() {
        // minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (min.empty()) {
            min.push(x);
        } else {
            if (min.peek() > x) {
                min.push(x);
            }
        }
        st.push(x);
    }

    public void pop() {
        if (st.peek() == min.peek()) {
            min.pop();
            //  minValue = min.peek();
        }
        st.pop();
    }

    public int top() {
        if (st.empty())
            return 0;
        return st.peek();

    }

    public int getMin() {
        if (!min.empty())
            return min.peek();
        return 0;
        // return minValue;

    }
}
