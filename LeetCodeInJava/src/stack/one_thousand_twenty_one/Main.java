package stack.one_thousand_twenty_one;

public class Main {
    public static void main(String[] args) {
        String str = "(()())(())(()(()))";
        System.out.println(new Solution().removeOuterParentheses(str));
    }
}
