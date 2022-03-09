package com.数据结构2.分治;

public class L_25_合并两个排序的链表 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }


    //递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val){
            l2.next = mergeTwoLists1(l1,l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }
    }
    //迭代
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 == null) cur.next = l2;
        if (l2 == null) cur.next = l1;

        return node.next;
    }

}
