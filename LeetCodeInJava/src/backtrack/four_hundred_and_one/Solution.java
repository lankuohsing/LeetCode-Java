package backtrack.four_hundred_and_one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Set<String> results = new HashSet<String>();
    Boolean[] hours = { false, false, false, false };
    Boolean[] minutes = { false, false, false, false, false, false };

    public List<String> readBinaryWatch(int num) {
        dfs(num);
        return new ArrayList<>(results);
    }

    private String getTime() {
        int hour = 0;
        int minute = 0;
        for (int i = hours.length - 1; i >= 0; i--) {
            if (hours[i]) {
                hour += (int) Math.pow(2, i);
            }
        }
        if (hour > 11) {
            return "";
        }
        for (int i = minutes.length - 1; i >= 0; i--) {
            if (minutes[i]) {
                minute += (int) Math.pow(2, i);
            }
        }
        if (minute > 59) {
            return "";
        }
        if (minute < 10) {
            return String.valueOf(hour) + ":0" + String.valueOf(minute);
        } else {
            return String.valueOf(hour) + ":" + String.valueOf(minute);
        }

    }

    private void dfs(int num) {
        if (num == 0) {
            String result = getTime();
            if (!"".equals(result)) {
                results.add(result);
            }
            return;
        }
        for (int i = 0; i < hours.length; i++) {
            if (!hours[i]) {
                hours[i] = true;
                dfs(num - 1);
                hours[i] = false;
            }

        }
        for (int i = 0; i < minutes.length; i++) {
            if (!minutes[i]) {
                minutes[i] = true;
                dfs(num - 1);
                minutes[i] = false;
            }
        }
    }
}
