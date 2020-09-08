package stack.basic_usage;

import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    static void showpush(Stack<Integer> st, int a) {
        st.push(new Integer(a));// 把项压入堆栈顶部。
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showPop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();// 移除堆栈顶部的对象，并作为此函数的值返回该对象。
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    static void showPeek(Stack<Integer> st) {
        System.out.print("peek -> ");
        Integer a = (Integer) st.peek();// 查看堆栈顶部的对象，但不从堆栈中移除它。
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        /*
         * 返回对象在堆栈中的位置，以 1 为基数,从栈顶开始计数
         */
        System.out.println("search 42: " + st.search(42));
        System.out.println("search 66: " + st.search(66));
        System.out.println("search 99: " + st.search(99));
        System.out.println("search 11: " + st.search(11));
        showPeek(st);
        showPop(st);
        showPop(st);
        showPop(st);
        try {
            showPop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}
