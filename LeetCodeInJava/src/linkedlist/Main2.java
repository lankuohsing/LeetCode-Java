package linkedlist;

/*
 * 函数对传入的对象数据类型的操作结果示例
 */
public class Main2 {
    public static void f1(ListNode listNode) {
        listNode = null;
    }

    public static void f2(ListNode listNode) {
        listNode.setVal(1);
        ;
    }

    public static ListNode f3(ListNode listNode) {
        listNode = null;
        return listNode;
    }

    public static ListNode f4(ListNode listNode) {
        listNode.setVal(2);
        ;
        return listNode;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(0);
        f1(x);
        System.out.println(x == null);
        System.out.println(x.getVal());
        f2(x);
        System.out.println(x.getVal());
        ListNode y = f3(x);
        System.out.println(x == null);
        System.out.println(y == null);
        ListNode z = f4(x);
        System.out.println(x.getVal());
        System.out.println(z.getVal());
    }
}
