package string.eight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static final String INT_MAX_STR = String.valueOf(Integer.MAX_VALUE);
    static final String INT_MIN_STR = String.valueOf(Integer.MIN_VALUE);

    public int myAtoi(String str) {
        // remove whitespace characters from beginning and ending
        String strTrimmed = str.trim();
        if (strTrimmed == null || strTrimmed.isEmpty()) {
            return 0;
        }
        if (!(strTrimmed.charAt(0) == '-' || strTrimmed.charAt(0) == '+'
                || (strTrimmed.charAt(0) >= '0' && strTrimmed.charAt(0) <= '9'))) {
            return 0;
        }
        String validNumberStr;
        String sign;
        Pattern numberPattern = Pattern.compile("(\\d+)");
        Matcher matcherNumber = numberPattern.matcher(strTrimmed);
        if (matcherNumber.find()) {

            validNumberStr = matcherNumber.group(1);
            if (validNumberStr == null) {
                return 0;
            }
            if (strTrimmed.equals(validNumberStr)) {
                sign = "+";
            } else {
                sign = strTrimmed.split(validNumberStr)[0];
            }
            if (!("-".equals(sign) || "+".equals(sign) || "".equals(sign))) {
                return 0;
            }
        } else {
            return 0;
        }
        validNumberStr = validNumberStr.replaceFirst("^0+", "");
        int minusTimes = 0;

        // 正数
        if (sign == null || "+".equals(sign) || sign.isEmpty()) {
            if (validNumberStr.length() > INT_MAX_STR.length()) {
                return Integer.MAX_VALUE;
            }
            boolean isOverFlow = false;
            if (validNumberStr.length() == INT_MAX_STR.length()) {
                for (int i = 0; i < validNumberStr.length(); i++) {
                    if (validNumberStr.charAt(i) > INT_MAX_STR.charAt(i)) {
                        isOverFlow = true;
                        break;
                    }
                    if (validNumberStr.charAt(i) < INT_MAX_STR.charAt(i)) {
                        isOverFlow = false;
                        break;
                    }
                }
            }
            if (isOverFlow) {
                return Integer.MAX_VALUE;
            }
        } else {
            if (validNumberStr.length() > INT_MIN_STR.length() - 1) {
                return Integer.MIN_VALUE;
            }
            boolean isOverFlow = false;
            if (validNumberStr.length() == INT_MIN_STR.length() - 1) {
                for (int i = 0; i < validNumberStr.length(); i++) {
                    if (validNumberStr.charAt(i) > INT_MIN_STR.charAt(i + 1)) {
                        isOverFlow = true;
                        break;
                    }
                    if (validNumberStr.charAt(i) < INT_MIN_STR.charAt(i + 1)) {
                        isOverFlow = false;
                        break;
                    }
                }
            }
            if (isOverFlow) {
                return Integer.MIN_VALUE;
            }
        }
        int result = 0;
        int times = 1;
        for (int i = 0; i < validNumberStr.length(); i++) {
            result += (validNumberStr.charAt(validNumberStr.length() - 1 - i) - 48) * times;
            times *= 10;
        }
        if ("-".equals(sign)) {
            result = result * -1;
        }

        return result;
    }
}
