package linkedlist;

import java.util.ArrayList;
import java.util.List;

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

    public void setVal(int val) {
        this.val = val;
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

/*
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
class Solution019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodeList = new ArrayList<ListNode>();
        ListNode cur = head;
        int num = 0;
        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
            num += 1;
        }
        int m = num - n - 1;
        if (m < 0) {
            return head.next;
        }
        ListNode right;
        if (m + 2 >= num) {
            right = null;
        } else {
            right = nodeList.get(m + 2);
        }
        nodeList.get(m).next = right;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode cur1 = head;
        ListNode cur2 = head;
        int m = 0;
        boolean isCur2Move = false;
        while (cur2 != null) {
            cur2 = cur2.next;

            if (m >= n + 1) {
                cur1 = cur1.next;
                isCur2Move = true;
            }
            m += 1;
        }
        if (m >= n + 1) {
            isCur2Move = true;
        }
        if (isCur2Move) {
            cur1.next = cur1.next.next;
        } else {
            head = head.next;
        }
        return head;

    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;

    }
}
