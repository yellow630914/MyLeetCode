import org.junit.jupiter.api.Test;

import java.util.Stack;

public class IsPalindromeNode {
    @Test
    public void testIsPalindromeNode(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    /**
     * Stack Case
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head){
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        for (int i = 0; i <= stack.size()/2; i++) {
            if (head.val != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 用快慢指針
     * @param head
     * @return
     */
    public boolean isPalindromeWithDoublePoint(ListNode head){
        ListNode fast = head;
        ListNode slow = fast;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;

        while (slow != null){
            if(fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode myReverseList(ListNode head){
        ListNode tail = null;
        if (head != null) {
            tail = reverse(head);
            head.next = null;
        }
        return tail;
    }
    public ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode tail = reverse(head.next);
        head.next.next = head;
        return tail;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
