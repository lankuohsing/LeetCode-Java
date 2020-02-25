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

class SumOfTwo002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int jinwei = 0;
        while (head1 != null || head2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (head1 != null) {
                val1 = head1.val;
            }
            if (head2 != null) {
                val2 = head2.val;
            }
            int sum = val1 + val2;
            result.val = sum + jinwei;
            if (result.val >= 10) {
                result.val -= 10;
                jinwei = 0;
                jinwei += 1;
            } else {
                jinwei = 0;
            }
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
            if (head1 != null || head2 != null) {
                result.next = new ListNode(0);
                result = result.next;
            } else {
                if (jinwei > 0) {
                    result.next = new ListNode(0);
                    result = result.next;
                    result.val += jinwei;
                }
            }
        }

        return head;
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
