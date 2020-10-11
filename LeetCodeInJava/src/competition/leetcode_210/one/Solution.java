package competition.leetcode_210.one;

public class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int temp = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
            case ')':
                right++;
                break;
            case '(':
                left++;
                break;
            default:
                temp = Math.abs(left - right);
                result = result > temp ? result : temp;

                break;
            }

        }
        return result;

    }
}