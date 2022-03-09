package com.数据结构1.Link;

public class L_21_合并两个有序链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            }else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            node.next = l2;
        } else {

            node.next = l1;
        }
        return head.next;
    }
}
