package linkedlist.two_hundred_and_six;

import linkedlist.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr1 = head.getNext();
        ListNode curr2 = head;
        while (curr1 != null) {
            head.setNext(curr1.getNext());
            curr1.setNext(curr2);
            curr2 = curr1;
            curr1 = head.getNext();
        }
        return curr2;
    }
}
