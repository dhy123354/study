package com.剑指offer;

public class L_24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null){
            ListNode node = head.next;
            head.next = pre;
            pre = head;
            head = node;
        }
        return pre;
    }

}
