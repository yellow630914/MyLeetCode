import org.junit.jupiter.api.Test;

public class MergeTwoLists {
    @Test
    public void testMergeTwoLists(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(5);

        ListNode head = mergeTwoListsWithRecursion(l1,l2);

        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
        System.out.println(head.next.next.next.next.val);
        System.out.println(head.next.next.next.next.next.val);
    }

    /**
     * While Case
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = new ListNode(0);
        ListNode pos = head;

        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                pos.next = list1;
                list1 = list1.next;
            } else {
                pos.next = list2;
                list2 = list2.next;
            }
            pos = pos.next;
        }
        pos.next = list1 == null ? list2:list1;
        return head.next;
    }

    /**
     * Recursion Case
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsWithRecursion(ListNode list1,ListNode list2){
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = mergeTwoListsWithRecursion(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoListsWithRecursion(list1,list2.next);
            return list2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



