package com.数据结构1.Link;

import java.util.Stack;

public class L_06_从尾到头打印链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
    //迭代
    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int len = stack.size();
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = stack.pop().val;
        }

        return num;
    }

    public int[] reversePrint(ListNode head){
        ListNode res = null;
        ListNode cur = head;
        ListNode pre = null;

        int count = 0;
        while (cur!=null){
            res = cur.next;
            cur.next = pre;
            pre = cur;
            cur = res;
            count ++;
        }

        int[] s = new int[count];
        for (int i = 0; i < count; i++) {
            s[0] = pre.val;
            pre = pre.next;
        }
        return s;
    }
}
