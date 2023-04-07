import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class DeleteNode {
    @Test
    public void testDeleteNode(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println(head.val);
        System.out.println(head.next.val);
        deleteNode(head);
        System.out.println(head.val);
        System.out.println(head.next.val);
    }

    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}
