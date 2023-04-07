import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    @Test
    public void testHasCycle(){

    }

    public boolean hasCycle(ListNode head){
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null){
            if(nodeSet.contains(head))
                return true;
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
