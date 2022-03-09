package com.数据结构1.Link;

import java.util.ArrayList;
import java.util.List;

public class L_203_移除链表元素 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode cur = listNode;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return listNode.next;
    }

    public ListNode removeElements2(ListNode head, int val){
        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode newnode = head;
        if (head == null) return head;
        while (newnode.next != null){
            if (newnode.next.val == val){
                newnode.next = newnode.next.next;
            }else {
                newnode = newnode.next;
            }
        }
        return head;
    }

    public ListNode removeElements(ListNode head, int val){
        if (head == null) return head;
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }
}
