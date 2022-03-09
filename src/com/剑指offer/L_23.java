package com.剑指offer;

public class L_23 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode meetingNode = MeetingNode(head);
        if (meetingNode == null)return null;

        int count = 1;
        ListNode node = meetingNode;
        while (node.next != meetingNode){
            node = node.next;
            ++count;
        }
        node = head;
        for (int i = count; i > 0; i--) {
            node = node.next;
        }
        ListNode node1 = head;
        while (node1 != node){
            node = node.next;
            node1 = node1.next;
        }
        return node;
    }

    public ListNode MeetingNode(ListNode pHead){
        if (pHead == null) return null;
        ListNode slow = pHead.next;
        if (slow == null) return null;
        ListNode fast = slow.next;
        while (fast != null && slow != null){
            if (fast == slow) return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }
}
