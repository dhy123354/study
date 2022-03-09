package com.剑指offer;

import java.util.HashMap;
import java.util.Map;

public class L_35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList1(Node head) {
        if (head == null) return head;
        //map中存的是（原节点，拷贝节点）的一个映射
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyRandomList(Node head){
        if (head == null) return head;
        Node cur = head;
        while (cur != null){
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        //构建新节点的random
        cur = head;
        while (cur != null){
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //拆分节点
        cur = head.next;
        Node pre = head,res = head.next;
        while (cur.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }
}
