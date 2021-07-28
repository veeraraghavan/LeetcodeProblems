package com.practice.scribble;

import java.util.Stack;

public class Asteroid {
    public static void main(String[] args) {
        Asteroid me = new Asteroid();
        me.asteroidCollision(new int[]{-2, -2, 1, -2});

    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            collision:
            {
                while (!st.empty() && st.peek() > 0 && asteroid < 0) {
                    if (st.peek() < -asteroid) {
                        st.pop();
                        continue;
                    } else if (st.peek() == -asteroid) {
                        st.pop();
                    }
                    break collision;
                }
                st.push(asteroid);
            }
        }

        int[] result = new int[st.size()];
        int size = st.size() - 1;
        while (!st.empty()) {
            result[size--] = st.pop();
        }
        return result;
    }

    int getSign(int a) {
        if (a >= 0)
            return 0;
        return 1;
    }
}
