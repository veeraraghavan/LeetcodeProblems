package com.practice.leetcode.linkedList;

import java.util.List;

//https://leetcode.com/problems/rotate-list/
public class SplitLinkedList {
    public static void main(String[] args) {

        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);
        SplitLinkedList me = new SplitLinkedList();
        me.splitListsWithoutExtraMemory(input,3);
        System.out.println("Came here");
    }

    public ListNode[] splitLists(ListNode root,int k){
        ListNode[] result = new ListNode[k];
        ListNode head = root;
        int N=0;
        while(head!=null){
            N++;
            head = head.next;
        }
        int size = N/k;
        int rem = N%k;
        head = root;
        for(int i=0;i<k;i++){
            ListNode temp = new ListNode(0);
            ListNode write = temp;
            for(int j=0;j<size + (i>=rem?0:1);j++){
                write = write.next = new ListNode(head.val);
                if(head!=null) head=head.next;

            }
            result[i] = temp.next;

        }
        return result;
    }
    public ListNode[] splitListsWithoutExtraMemory(ListNode root,int k){
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (cur != null) cur = cur.next;
            }
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }
}


