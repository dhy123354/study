package com.剑指offer;

public class L_18 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head,int val){

        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode cur = pHead;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return pHead.next;
    }
}
