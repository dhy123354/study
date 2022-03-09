package com.数据结构1.Link;

public class L_707_设计链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class MyLinkedList {
        int size;
        ListNode head;
        /** Initialize your data structure here. */
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
        if (index<0 || index>=size) return -1;

        ListNode list = head;
        for (int i = 0;i<=index;i++){
            list = list.next;
        }
        return list.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            deleteAtIndex(0);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index<0 || index>size) return ;
            ListNode list = head;
            for (int i =0 ;i<index;i++) list = list.next;
             ListNode add = new ListNode(val);
             add.next = list.next;
             list.next = add;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;

            size--;
            // find predecessor of the node to be deleted
            ListNode pred = head;
            for(int i = 0; i < index; ++i) pred = pred.next;

            // delete pred.next
            pred.next = pred.next.next;
        }
    }
}
