package com.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

public class L_06 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public int[] reversePrint1(ListNode head){

        ListNode pre = null;
        int count  = 0;
        while (head != null){
            ListNode node = head.next;
            head.next = pre;
            pre = head;
            head = node;
            count++;
        }
        int[] nums = new int[count];
        int i = 0;
        while (pre!=null){
            nums[i] = pre.val;
            pre = pre.next;
            i++;
        }
        return nums;
    }

    //  递归
    ArrayList<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head){
        recur(head);
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    void recur(ListNode node){
        if (node == null) return;
        recur(node.next);
        list.add(node.val);
    }

}
