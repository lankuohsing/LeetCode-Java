package competition.leetcode_210.two;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] edgeNumOfIndex = new int[100];
        List<Integer> temps = new ArrayList<Integer>();
        List<Integer> lefts = new ArrayList<Integer>();
        List<Integer> rights = new ArrayList<Integer>();
        for (int i = 0; i < roads.length; i++) {
            edgeNumOfIndex[roads[i][0]]++;
            edgeNumOfIndex[roads[i][1]]++;
        }
        int result = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i < 99; i++) {
            for (int j = i + 1; j < 100; j++) {
                if (edgeNumOfIndex[i] == 0 && edgeNumOfIndex[j] == 0) {
                    continue;
                }
                int temp = edgeNumOfIndex[i] + edgeNumOfIndex[j];
                temps.add(temp);
                lefts.add(i);
                rights.add(j);
                if (temp > result) {
                    result = temp;
                    left = i;
                    right = j;
                }
            }
        }
        int finalResult = 0;
        for (int j = 0; j < temps.size(); j++) {
            if (temps.get(j) == result) {
                int temp = temps.get(j);
                for (int i = 0; i < roads.length; i++) {
                    if ((roads[i][0] == lefts.get(j) && roads[i][1] == rights.get(j))
                            || (roads[i][0] == rights.get(j) && roads[i][1] == lefts.get(j))) {
                        temp--;
                        break;
                    }
                }
                finalResult = finalResult > temp ? finalResult : temp;
            }
        }

        return finalResult;
    }
}
