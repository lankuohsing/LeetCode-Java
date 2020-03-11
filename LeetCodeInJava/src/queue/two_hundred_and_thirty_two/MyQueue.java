package queue.two_hundred_and_thirty_two;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int stack1Size = stack1.size();
        for (int i = 0; i < stack1Size - 1; i++) {
            stack2.push(stack1.pop());
        }
        int x = stack1.pop();
        int stack2Size = stack2.size();
        for (int i = 0; i < stack2Size; i++) {
            stack1.push(stack2.pop());
        }
        return x;

    }

    /** Get the front element. */
    public int peek() {
        int stack1Size = stack1.size();
        for (int i = 0; i < stack1Size - 1; i++) {
            stack2.push(stack1.pop());
        }
        int x = stack1.pop();
        stack1.push(x);
        int stack2Size = stack2.size();
        for (int i = 0; i < stack2Size; i++) {
            stack1.push(stack2.pop());
        }

        return x;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
