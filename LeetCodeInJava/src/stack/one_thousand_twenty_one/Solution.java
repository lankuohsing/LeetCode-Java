package stack.one_thousand_twenty_one;

import java.util.Stack;

class Solution {
    public String removeOuterParentheses(String S) {
        char[] charArr = S.toCharArray();
        Stack<Character> charStack = new Stack<Character>();
        int length = S.length();
        int left = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                charStack.pop();
                if (charStack.isEmpty()) {
                    charArr[i] = '+';
                    charArr[left] = '+';
                    length -= 2;
                    left = i + 1;
                }
            } else {
                charStack.push('(');
            }
        }
        char[] newCharArr = new char[length];
        int j = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '+') {
                continue;
            }
            newCharArr[j] = charArr[i];
            j++;
        }
        String result = new String(newCharArr);
        return result;

    }
}
