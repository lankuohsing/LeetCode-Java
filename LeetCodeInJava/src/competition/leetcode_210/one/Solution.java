package competition.leetcode_210.one;

public class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
            case ')':
                depth--;
                break;
            case '(':
                depth++;
                result = result > depth ? result : depth;
                break;
            default:
                break;
            }
        }
        return result;
    }
}