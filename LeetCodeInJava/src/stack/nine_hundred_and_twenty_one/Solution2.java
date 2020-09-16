package stack.nine_hundred_and_twenty_one;

public class Solution2 {
    public int minAddToMakeValid(String S) {
        int bal = 0;
        int result = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                bal++;
            }
            if (c == ')') {
                if (bal <= 0) {
                    result -= bal;
                    result += 1;
                    bal = 0;
                } else {
                    bal--;
                }
            }
        }
        return result + bal;
    }
}
