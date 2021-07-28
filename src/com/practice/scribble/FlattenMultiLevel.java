package com.practice.scribble;

import java.util.Map;
import java.util.Stack;

class MNode {
    public int val;
    public MNode prev;
    public MNode next;
    public MNode child;
};

public class FlattenMultiLevel {
    public static void main(String[] args) {
        FlattenMultiLevel me = new FlattenMultiLevel();

    }

    public MNode flatten(MNode head) {
        Stack<MNode> st = new Stack<>();
        MNode cur = head;
        // whenever the child exists traverse
        while (true) {
            while (cur != null) {
                if (cur.child == null) {
                    if (cur.next != null)
                        cur = cur.next;
                    else
                        break;
                } else {
                    if (cur.next != null) {
                        st.push(cur.next);
                    }
                    cur.next = cur.child;
                    cur.child.prev = cur;
                    cur.child = null;
                }
            }
            if (!st.empty()) {
                cur.next = st.pop();
                cur.next.prev = cur;
                cur = cur.next;
            } else {
                break;
            }

            break;
        }
        return head;

    }
}
