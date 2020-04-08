package string.five_hundred_and_sixty_four;

public class Solution {
    public String nearestPalindromic(String n) {
        String result;
        boolean evenSize = n.length() % 2 == 0;
        boolean middleZero;
        int startIndex = (int) Math.ceil(n.length() / 2.0);
        middleZero = n.charAt(startIndex - 1) == '0';

        char[] rightHalf = new char[(int) Math.floor(n.length() / 2.0)];
        int oriNum = 0;
        int newNum = 0;
        int times = 1;
        int num1 = 0;
        int num2 = 0;
        for (int i = n.length() - 1; i >= startIndex; i--) {
            rightHalf[i - startIndex] = n.charAt(n.length() - 1 - i);
            oriNum += times * (n.charAt(i) - '0');
            newNum += times * (n.charAt(n.length() - 1 - i) - '0');
            times *= 10;
        }
        oriNum += times * (n.charAt(startIndex - 1) - '0');
        num1 = newNum + times * (n.charAt(startIndex - 1) - '0');
        num2 = newNum + times * (n.charAt(startIndex - 1) - '0' - 1)
                - times / 10 * (n.charAt(startIndex - 1) - '0' - 1);
        if (Math.abs(num2 - oriNum) <= Math.abs(num1 - oriNum)) {
            result = n.substring(0, startIndex - 1) + new String(n.substring(startIndex - 1, startIndex))
                    + new String(rightHalf);
            return null;
        } else {
            return null;
        }

    }
}
