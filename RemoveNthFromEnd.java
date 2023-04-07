import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class RemoveNthFromEnd {
    @Test
    public void testRemoveNthFromEnd(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head = removeNthFromEndWithRecursion(head,2);

        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
        System.out.println(head.next.next.next.next.val);
    }

    /**
     * My Case
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode pointer = head;
        int size = 1;
        while (pointer.next != null){
            size++;
            pointer = pointer.next;
        }

        if (size - n == 0){
            return head.next;
        }

        pointer = head;

        for (int i = 0; i < size - n; i++) {
            pointer = pointer.next;
        }
        deleteNextNode(pointer);
        return head;
    }
    public void deleteNextNode(ListNode node){
        if (node.next != null && node.next.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
    }

    /**
     * Recursion Case
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndWithRecursion(ListNode head, int n){
        int pos = length(head, n);
        if (pos == n)
            return head.next;
        return head;
    }
    public int length(ListNode node, int n) {
        // 如果node是null，代表上一個傳參進來的node是最後一個。
        if (node == null)
            return 0;
        // 進入遞歸點，依順序將node傳入，並在return的時候+1，pos用於定位現在是倒數第幾位。
        int pos = length(node.next, n) + 1;
        // 當現在的node是倒數第n的前一位時，將現在的node指向倒數第n位的下一位。
        if (pos == n + 1)
            node.next = node.next.next;
        // 結束此層遞歸，並回傳定位，以便上一層的遞歸定位自己的位置。
        return pos;
    }


    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
