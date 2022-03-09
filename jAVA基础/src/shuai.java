import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class shuai {

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reversal(slow.next);
        fast = head;
        while (slow != null){
            if (slow.val != fast.val)return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reversal(ListNode next) {
        if (next == null) return  null;
        ListNode pre =null,cur = next;
        while (next != null){
            cur = next.next;
            next.next = pre;
            pre = next;
            next = cur;
        }
        return pre;
    }
}
