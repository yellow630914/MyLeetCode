import org.junit.jupiter.api.Test;

public class ReverseList {
    @Test
    public void testReverseList(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head = reverseList(head);

        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
        System.out.println(head.next.next.next.next.val);
        System.out.println(head.next.next.next.next.next.val);
    }

    public ListNode reverseList(ListNode head){
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
