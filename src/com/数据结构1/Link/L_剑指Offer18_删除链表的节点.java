package com.数据结构1.Link;

public class L_剑指Offer18_删除链表的节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        while (head!=null){
            if (node.val == val){
                return head.next;
            }
            if (head.next.val == val){
                head.next =head.next.next;
                break;
            }
            head = head.next;
        }
        return node;
    }
}
