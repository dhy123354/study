package com.数据结构2.Sort;

import java.util.Stack;

public class L_147_对链表进行插入排序 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public ListNode insertionSortList(ListNode head) {
        ListNode dumyHead = new ListNode(0);
        dumyHead.next = head;

        ListNode pre = null;
        ListNode p =head;
        while (p != null && p.next != null){
            if (p.val <= p.next.val){
                p = p.next;
                continue;
            }
            pre = dumyHead;

            ListNode q = p.next;
            while (pre.next.val < q.val){
                pre = pre.next;
            }
            p.next = q.next;
            q.next = pre.next;
            pre.next = q;
        }
        return dumyHead.next;
    }


}
