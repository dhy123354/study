package com.数据结构1.Link;

public class L_24__两两交换链表中的节点 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    //迭代
    public ListNode swapPairs1(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode cur = head;
        ListNode node1 = node;
        while (cur != null && cur.next != null){
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = cur;
            node1.next = temp;
            node1 = cur;
            cur = cur.next;
        }
        return node.next;
    }

    //递归
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = head.next;
        head.next = swapPairs1(node.next);
        node.next = head;
        return node;
    }
}
