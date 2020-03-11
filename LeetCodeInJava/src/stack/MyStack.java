package stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int queue1Size = queue1.size();
        for (int i = 0; i < queue1Size - 1; i++) {
            queue2.add(queue1.poll());
        }
        int x = queue1.poll();
        int queue2Size = queue2.size();
        for (int i = 0; i < queue2Size; i++) {
            queue1.add(queue2.poll());
        }
        return x;

    }

    /** Get the top element. */
    public int top() {
        int queue1Size = queue1.size();
        for (int i = 0; i < queue1Size - 1; i++) {
            queue2.offer(queue1.poll());
        }
        int x = queue1.poll();
        queue2.offer(x);
        int queue2Size = queue2.size();
        for (int i = 0; i < queue2Size; i++) {
            queue1.offer(queue2.poll());
        }
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
