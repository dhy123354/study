package com.数据结构1.Link;

public class L_83_删除排序链表中的重复元素 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode newnode = head;
        ListNode newnode1 = head.next;
        while (newnode1!=null){
            if (newnode.val == newnode1.val){
                newnode.next = newnode1.next;
                newnode1 = newnode1.next;
            }else {
                newnode = newnode1;
                newnode1 = newnode1.next;
            }
        }
        return head;
    }
}
