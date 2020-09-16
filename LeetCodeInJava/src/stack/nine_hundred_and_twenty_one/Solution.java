package stack.nine_hundred_and_twenty_one;

import java.util.Stack;

public class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> myStack = new Stack<Character>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                myStack.push(c);
            }
            if (c == ')') {
                if (!myStack.isEmpty() && myStack.peek() == '(') {
                    myStack.pop();
                } else {
                    myStack.push(c);
                }
            }
        }
        return myStack.size();
    }
}
