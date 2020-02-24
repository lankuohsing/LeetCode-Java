package linkedlist.two_hundred_and_six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import linkedlist.ListNode;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ListNode head = new ListNode(list1.get(0));
        ListNode cur = head;
        for (int i = 1; i < list1.size(); i++) {
            ListNode node = new ListNode(list1.get(i));
            cur.setNext(node);
            cur = node;
        }
        cur = head;
        while (cur != null) {
            System.out.println(cur.getVal());
            cur = cur.getNext();
        }
        Solution solution = new Solution();
        ListNode cur1 = solution.reverseList(head);
        while (cur1 != null) {
            System.out.println(cur1.getVal());
            cur1 = cur1.getNext();
        }
    }
}
