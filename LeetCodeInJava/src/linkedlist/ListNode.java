package linkedlist;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void setNext(ListNode node) {
        this.next = node;
    }

    public ListNode getNext() {
        return this.next;
    }

    public int getVal() {
        return val;
    }

    public ListNode Reverse() {
        Reverse206 reverse206 = new Reverse206();
        return reverse206.reverseList(this);
    }
}

class Reverse206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr1 = head.next;
        ListNode curr2 = head;
        while (curr1 != null) {
            head.next = curr1.next;
            curr1.next = curr2;
            curr2 = curr1;
            curr1 = head.next;
        }
        return curr2;
    }
}
