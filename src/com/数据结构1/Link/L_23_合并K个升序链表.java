package com.数据结构1.Link;

import java.util.*;

public class L_23_合并K个升序链表 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode cur = new ListNode();
        ListNode ans = cur;
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)q.offer(lists[i]);
        }
        while (!q.isEmpty()){
            cur.next = q.poll();
            cur = cur.next;
            if (cur.next != null)q.offer(cur.next);
        }
        return ans.next;
    }
}
