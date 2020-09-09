package stack.twenty;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> strStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
            case ')':
                if (strStack.isEmpty() || strStack.peek() != '(') {
                    return false;
                }
                strStack.pop();
                break;
            case '}':
                if (strStack.isEmpty() || strStack.peek() != '{') {
                    return false;
                }
                strStack.pop();
                break;
            case ']':
                if (strStack.isEmpty() || strStack.peek() != '[') {
                    return false;
                }
                strStack.pop();
                break;
            default:
                strStack.push(s.charAt(i));
                break;
            }

        }
        if (strStack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
