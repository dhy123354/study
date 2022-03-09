package com.剑指offer;

import java.util.Stack;

public class L_52 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node01 = headA,node02 = headB;
        while (node01 != node02){
            node01 = node01 == null ? headB : node01.next;
            node02 = node02 == null ? headA : node02.next;
        }
        return node01;
    }



}
