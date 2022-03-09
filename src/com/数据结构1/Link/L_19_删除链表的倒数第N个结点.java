package com.数据结构1.Link;

public class L_19_删除链表的倒数第N个结点 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        ListNode node = new ListNode(0,head);
        ListNode slow = head,fast = head;
        int i = 0;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
            i++;
            if (i == n)
                slow = node;
        }
        slow.next = slow.next.next;
        return node.next;
    }
}
