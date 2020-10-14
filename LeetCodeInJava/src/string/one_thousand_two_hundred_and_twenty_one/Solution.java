package string.one_thousand_two_hundred_and_twenty_one;

class Solution {
    public int balancedStringSplit(String s) {
        int leftNum = 0;
        int rightNum = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                leftNum++;
                if (leftNum == rightNum) {
                    result++;
                    leftNum = 0;
                    rightNum = 0;
                }
            }

            if (s.charAt(i) == 'R') {
                rightNum++;
                if (leftNum == rightNum) {
                    result++;
                    leftNum = 0;
                    rightNum = 0;
                }
            }

        }
        return result;
    }
}
