package string.one_thousand_one_hundred_and_sixty_three;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String lastSubstring(String s) {
        List<List<Integer>> list1 = new ArrayList<List<Integer>>();
        for (int i = 0; i < 26; i++) {
            list1.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < s.length(); i++) {
            list1.get(s.charAt(i) - 'a').add(i);
        }
        int targetLetter = 0;
        for (int i = list1.size() - 1; i >= 0; i--) {
            if (list1.get(i).size() > 0) {
                targetLetter = i;
                break;
            }
        }
        boolean isOneUniqueLetter = true;
        for (int i = targetLetter - 1; i >= 0; i--) {
            if (list1.get(i).size() > 0) {
                isOneUniqueLetter = false;
                break;
            }
        }
        if (isOneUniqueLetter) {
            return s;
        }
        int targetPos = 0;
        for (int i = 1; i < list1.get(targetLetter).size();) {
            boolean isBreak = false;
            for (int j = 1; j < s.length() - list1.get(targetLetter).get(i); j++) {
                if (s.charAt(j + list1.get(targetLetter).get(i)) > s
                        .charAt(j + list1.get(targetLetter).get(targetPos))) {
                    targetPos = i;
                    i = targetPos + 1;
                    isBreak = true;
                    break;
                } else {
                    if (s.charAt(j + list1.get(targetLetter).get(i)) < s
                            .charAt(j + list1.get(targetLetter).get(targetPos))) {
                        i++;
                        isBreak = true;
                        break;
                    }
                }
            }
            if (!isBreak) {
                i++;
            }
        }

        return s.substring(list1.get(targetLetter).get(targetPos));
    }
}
