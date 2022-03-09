package com.数据结构1.Link;

public class L_876_链表的中间结点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //快指针和慢指针方法
    //快指针每次走两步，慢指针每次走一步
    //当快指针到达终点，慢指针刚好走到中间
    public ListNode middleNode2(ListNode head) {
        ListNode p = head,q =head;
        while (p!=null && p.next!=null){
            p =  p.next.next;
            q = q.next;
        }
        return q;
    }
    //将链表转化为数组的方法
    public ListNode middleNode1(ListNode head){
        ListNode[] a = new ListNode[100];
        int t= 0;
        while (head!=null){
            a[t++] = head;
            head = head.next;
        }
        return a[t/2];
    }
    //单指针方法
    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode newnode = head;
        while (newnode != null) {
            ++n;
            newnode = newnode.next;
        }
        int k = 0;
        newnode = head;
        while (k < n / 2) {
            ++k;
            newnode = newnode.next;
        }
        return newnode;
    }
}
