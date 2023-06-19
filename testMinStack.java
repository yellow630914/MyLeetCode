import org.junit.jupiter.api.Test;

public class testMinStack {
    @Test
    public void testMinStack(){
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(-2);
        minStack.push(1);
        minStack.push(-4);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    ListNode head;

    public MinStack() {}

    public void push(int val) {
        if (head != null) {
            head = new ListNode(val,Math.min(val, head.min),head);
        } else {
            head = new ListNode(val,Math.min(val, val),null);
        }
    }

    public void pop() {
        if (head == null) {
            System.out.println("空");
        }
        head = head.next;
    }

    public int top() {
        if (head == null) {
            System.out.println("空");
        }
        return head.val;
    }

    public int getMin() {
        if (head == null) {
            System.out.println("空");
        }
        return head.min;
    }
}

class ListNode {
    public int val;
    public int min;
    public ListNode next;

    public ListNode(int val,int min,ListNode next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
