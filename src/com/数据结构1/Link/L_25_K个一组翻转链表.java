package com.数据结构1.Link;

import java.util.ArrayDeque;
import java.util.Deque;

public class L_25_K个一组翻转链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode node = new ListNode(0);
        ListNode p = node;
        while (true){
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k){
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k){
                p.next = head;
                break;
            }
            while (!stack.isEmpty()){
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return node.next;
    }
}
